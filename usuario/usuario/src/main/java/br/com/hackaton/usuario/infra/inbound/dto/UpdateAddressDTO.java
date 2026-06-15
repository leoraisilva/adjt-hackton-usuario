package br.com.hackaton.usuario.infra.inbound.dto;

public record UpdateAddressDTO(String ibge, String cep, String logradouro, String complemento, String bairro, String localidade, String estado, String uf) {
}
