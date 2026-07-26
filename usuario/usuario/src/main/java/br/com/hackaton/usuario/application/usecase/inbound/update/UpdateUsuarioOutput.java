package br.com.hackaton.usuario.application.usecase.inbound.update;

import br.com.hackaton.usuario.application.domain.Address;
import br.com.hackaton.usuario.application.domain.Status;
import br.com.hackaton.usuario.application.domain.Usuario;
import br.com.hackaton.usuario.application.usecase.inbound.create.CreateUsuarioOutput;

public record UpdateUsuarioOutput (String idUsuario, String nome, String cpf, Status status, Address address, String tell, String email) {
    public static UpdateUsuarioOutput from (Usuario usuario) {
        return new UpdateUsuarioOutput(
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
