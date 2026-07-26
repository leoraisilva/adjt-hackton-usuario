package br.com.hackaton.usuario.infra.addapter.outbound.persistent.entity;

import br.com.hackaton.usuario.application.domain.Status;
import jakarta.persistence.*;

@Entity
@Table(name = "usuario_tb")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idUsuario;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;
    @Column(name = "status", nullable = false)
    private String status;
    @ManyToOne(targetEntity = AddressEntity.class)
    @JoinColumn(name = "cep")
    private AddressEntity endereco;
    @Column(name = "tell", nullable = false)
    private String tell;
    @Column(name = "email", nullable = false)
    private String email;

    public UsuarioEntity(String idUsuario, String nome, String cpf, String status, AddressEntity endereco, String tell, String email) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.cpf = cpf;
        this.status = status;
        this.endereco = endereco;
        this.tell = tell;
        this.email = email;
    }

    public UsuarioEntity () {}

    public String getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getStatus() {
        return status;
    }

    public AddressEntity getEndereco() {
        return endereco;
    }

    public String getTell() {
        return tell;
    }

    public String getEmail() {
        return email;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setEndereco(AddressEntity endereco) {
        this.endereco = endereco;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
