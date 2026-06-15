package br.com.hackaton.usuario.infra.inbound.dto;

import br.com.hackaton.usuario.application.domain.Status;

public record UpdateUsuarioDTO (String idUsuario, String nome, String cpf, Status status, String cep, String tell, String email) {
}
