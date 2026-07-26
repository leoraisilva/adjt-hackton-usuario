package br.com.hackaton.usuario.application.usecase.inbound.delete;

import br.com.hackaton.usuario.application.domain.Address;
import br.com.hackaton.usuario.application.domain.Status;
import br.com.hackaton.usuario.application.domain.Usuario;
import br.com.hackaton.usuario.application.usecase.inbound.create.CreateUsuarioOutput;

public record DeleteUsuarioOutput (String idUsuario, String nome, String cpf, Status status, Address endereco, String tell, String email) {
    public static DeleteUsuarioOutput from (Usuario usuario) {
        return new DeleteUsuarioOutput(
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
