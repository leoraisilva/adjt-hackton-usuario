package br.com.hackaton.usuario.infra.inbound.dto;

import br.com.hackaton.usuario.application.domain.Status;

public record CreateUsuarioDTO(String nome, String cpf, Status status, String cep, String tell, String email) {
}
