package br.com.hackaton.usuario.infra.outbound.persistent.entity;

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
    private Status status;
    @Column(name = "cep")
    private String cep;
    @Column(name = "tell", nullable = false)
    private String tell;
    @Column(name = "email", nullable = false)
    private String email;

    public UsuarioEntity(String idUsuario, String nome, String cpf, Status status, String cep, String tell, String email) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.cpf = cpf;
        this.status = status;
        this.cep = cep;
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

    public Status getStatus() {
        return status;
    }

    public String getCep() {
        return cep;
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

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
