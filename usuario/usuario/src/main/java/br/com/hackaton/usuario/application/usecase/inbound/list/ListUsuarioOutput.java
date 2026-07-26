package br.com.hackaton.usuario.application.usecase.inbound.list;

import br.com.hackaton.usuario.application.domain.Address;
import br.com.hackaton.usuario.application.domain.Status;
import br.com.hackaton.usuario.application.domain.Usuario;

public record ListUsuarioOutput (String idUsuario, String nome, String cpf, Status status, Address address, String tell, String email) {
    public static ListUsuarioOutput from (Usuario usuario) {
        return new ListUsuarioOutput(
                usuario.getIdUsuario(),
                usuario.getNome(),
                usuario.getCpf(),
                usuario.getStatus(),
                usuario.getEndereco(),
                usuario.getTell(),
                usuario.getEmail()
        );
    }
}
