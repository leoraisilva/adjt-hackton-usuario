package br.com.hackaton.usuario.application.usecase.inbound.search;

import br.com.hackaton.usuario.application.domain.Address;
import br.com.hackaton.usuario.application.domain.Status;
import br.com.hackaton.usuario.application.domain.Usuario;

public record SearchUsuarioOutput (String idUsuario, String nome, String cpf, Status status, Address endereco, String tell, String email) {
    public static SearchUsuarioOutput from (Usuario usuario) {
        return new SearchUsuarioOutput(
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
