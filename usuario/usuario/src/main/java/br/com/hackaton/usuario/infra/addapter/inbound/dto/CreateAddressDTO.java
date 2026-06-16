package br.com.hackaton.usuario.infra.addapter.inbound.dto;

import br.com.hackaton.usuario.application.domain.Status;

import java.util.Objects;

public record CreateAddressDTO(String ibge, String cep, String logradouro, String complemento, String bairro, String localidade, String estado, String uf) {
    public CreateAddressDTO {
        Objects.requireNonNull(cep, "Campo CEP é obrigatorio!!");
        if(!cep.matches("\\d{8}") || cep.matches("(\\d)\\1{7}")){
            throw new IllegalArgumentException("Campo CEP está errado");
        }
        if (!cep.matches("\\d+")) {
            throw new IllegalArgumentException("CEP deve conter apenas números");
        }
    }
}
