package br.com.hackaton.usuario.infra.addapter.inbound.dto;

import java.util.Objects;

public record UpdateAddressDTO(String cep, String codigoMunicipal, String logradouro, String complemento, String bairro, String localidade, String estado, String uf) {
    public UpdateAddressDTO {
        Objects.requireNonNull(cep, "Campo CEP é obrigatorio!!");
        if(!cep.matches("\\d{8}") || cep.matches("(\\d)\\1{7}")){
            throw new IllegalArgumentException("Campo CEP está errado");
        }
        if (!cep.matches("\\d+")) {
            throw new IllegalArgumentException("CEP deve conter apenas números");
        }
    }
}
