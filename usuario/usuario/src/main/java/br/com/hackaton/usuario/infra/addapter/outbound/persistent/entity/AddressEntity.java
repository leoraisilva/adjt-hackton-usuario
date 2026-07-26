package br.com.hackaton.usuario.infra.addapter.outbound.persistent.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "address_tb")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idAddress;
    @Column(name = "cep", nullable = false)
    private String cep;
    @Column(name = "codigo_municipal")
    private String codigoMunicipal;

    @Column(name = "logradouro", nullable = false)
    private String logradouro;
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "localidade")
    private String localidade;
    @Column(name = "estado")
    private String estado;
    @Column(name = "uf")
    private String uf;

    public AddressEntity(String cep, String codigoMunicipal, String logradouro, String complemento, String bairro, String localidade, String estado, String uf) {
        this.cep = cep;
        this.codigoMunicipal = codigoMunicipal;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.estado = estado;
        this.uf = uf;
    }

    public AddressEntity() {}

    public String getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(String idAddress) {
        this.idAddress = idAddress;
    }

    public String getCodigoMunicipal() {
        return codigoMunicipal;
    }

    public void setCodigoMunicipal(String codigoMunicipal) {
        this.codigoMunicipal = codigoMunicipal;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
