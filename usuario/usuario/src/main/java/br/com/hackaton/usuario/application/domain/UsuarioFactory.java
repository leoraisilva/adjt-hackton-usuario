package br.com.hackaton.usuario.application.domain;

public interface UsuarioFactory {
    Usuario novoUsuario (String idUsuario, String nome, Status status, String cpf, String cep, String tell, String email);
}
