package br.com.hackaton.usuario.infra.addapter.inbound.dto;

import br.com.hackaton.usuario.application.domain.Address;
import br.com.hackaton.usuario.application.domain.Status;
import br.com.hackaton.usuario.application.usecase.inbound.update.UpdateUsuarioInput;

import java.util.Objects;

public record UpdateUsuarioDTO (String nome, String cpf, Status status, UpdateAddressDTO endereco, String tell, String email) {

    public UpdateUsuarioDTO {
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

    public static UpdateUsuarioInput to (UpdateUsuarioDTO updateDTO) {
        return new UpdateUsuarioInput(
                updateDTO.nome(),
                updateDTO.cpf(),
                updateDTO.status(),
                new Address.AddressBuilder()
                        .withCEP(updateDTO.endereco().cep())
                        .withBairro(updateDTO.endereco().bairro())
                        .withComplemento(updateDTO.endereco().complemento())
                        .withEstado(updateDTO.endereco().estado())
                        .withLocalidade(updateDTO.endereco().localidade())
                        .withLogradouro(updateDTO.endereco().logradouro())
                        .withCodigoMunicipal(updateDTO.endereco().codigoMunicipal())
                        .withUF(updateDTO.endereco().uf())
                        .build(),
                updateDTO.tell,
                updateDTO.email
        );
    }
}
