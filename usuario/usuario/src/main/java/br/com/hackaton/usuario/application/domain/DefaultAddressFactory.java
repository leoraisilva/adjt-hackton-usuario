package br.com.hackaton.usuario.application.domain;

public class DefaultAddressFactory implements AddressFactory{
    @Override
    public Address novoAddress(String ibge, String cep, String logradouro, String complemento, String bairro, String localidade, String estado, String uf) {
        return new Address.AddressBuilder()
                .withIBGE(ibge)
                .withCEP(cep)
                .withLogradouro(logradouro)
                .withComplemento(complemento)
                .withBairro(bairro)
                .withLocalidade(localidade)
                .withEstado(estado)
                .withUF(uf)
                .build();
    }
}
