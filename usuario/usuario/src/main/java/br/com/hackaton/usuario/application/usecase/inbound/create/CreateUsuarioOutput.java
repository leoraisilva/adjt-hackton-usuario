package br.com.hackaton.usuario.application.usecase.inbound.create;

import br.com.hackaton.usuario.application.domain.Address;
import br.com.hackaton.usuario.application.domain.Status;
import br.com.hackaton.usuario.application.domain.Usuario;

public record CreateUsuarioOutput (String idUsuario, String nome, String cpf, Status status, Address address, String tell, String email) {
    public static CreateUsuarioOutput from (Usuario usuario, Address address) {
        return new CreateUsuarioOutput(
                usuario.getIdUsuario(),
                usuario.getNome(),
                usuario.getCpf(),
                usuario.getStatus(),
                address,
                usuario.getTell(),
                usuario.getEmail()
        );
    }
}
