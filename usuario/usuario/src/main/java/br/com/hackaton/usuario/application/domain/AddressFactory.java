package br.com.hackaton.usuario.application.domain;

public interface AddressFactory {
    Address novoAddress (String cep, String codigoMunicipal, String logradouro, String complemento, String bairro, String localidade, String estado, String uf);
}
