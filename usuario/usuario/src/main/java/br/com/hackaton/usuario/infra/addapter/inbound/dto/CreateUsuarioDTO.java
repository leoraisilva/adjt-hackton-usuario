package br.com.hackaton.usuario.infra.addapter.inbound.dto;

import br.com.hackaton.usuario.application.domain.Address;
import br.com.hackaton.usuario.application.domain.Status;
import br.com.hackaton.usuario.application.usecase.inbound.create.CreateUsuarioInput;

import java.util.Objects;

public record CreateUsuarioDTO(String nome, String cpf, Status status, CreateAddressDTO addressDTO, String tell, String email) {

    public CreateUsuarioDTO {
        Objects.requireNonNull(nome, "Campo nome é obrigatorio!!");
        Objects.requireNonNull(cpf, "Campo CPF é obrigatorio!!");
        if (!isValidCPF(cpf)) {
            throw new IllegalArgumentException("Campo CPF está errado");
        }
        if (!cpf.matches("\\d+")) {
            throw new IllegalArgumentException("CPF deve conter apenas números");
        }
    }

    private static boolean isValidCPF(String cpf) {
        if (!cpf.matches("\\d{11}") || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }

        int resto = soma % 11;
        int digito1 = resto < 2 ? 0 : 11 - resto;

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }

        resto = soma % 11;
        int digito2 = resto < 2 ? 0 : 11 - resto;

        return digito1 == Character.getNumericValue(cpf.charAt(9))
                && digito2 == Character.getNumericValue(cpf.charAt(10));
    }

    public static CreateUsuarioInput to (CreateUsuarioDTO createDTO) {
        return new CreateUsuarioInput(
                createDTO.nome(),
                createDTO.cpf(),
                createDTO.status(),
                new Address.AddressBuilder()
                        .withCEP(createDTO.addressDTO().cep())
                        .withBairro(createDTO.addressDTO().bairro())
                        .withComplemento(createDTO.addressDTO().complemento())
                        .withEstado(createDTO.addressDTO().estado())
                        .withLocalidade(createDTO.addressDTO().localidade())
                        .withLogradouro(createDTO.addressDTO().logradouro())
                        .withIBGE(createDTO.addressDTO().ibge())
                        .withUF(createDTO.addressDTO().uf())
                        .build(),
                createDTO.tell,
                createDTO.email
        );
    }
}
