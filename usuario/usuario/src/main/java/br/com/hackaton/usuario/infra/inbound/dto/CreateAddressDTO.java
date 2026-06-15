package br.com.hackaton.usuario.infra.inbound.dto;

import br.com.hackaton.usuario.application.domain.Status;

public record CreateAddressDTO(String ibge, String cep, String logradouro, String complemento, String bairro, String localidade, String estado, String uf) {
}
