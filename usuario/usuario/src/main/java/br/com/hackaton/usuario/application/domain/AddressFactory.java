package br.com.hackaton.usuario.application.domain;

public interface AddressFactory {
    Address novoAddress (String ibge, String cep, String logradouro, String complemento, String bairro, String localidade, String estado, String regiao);
}
