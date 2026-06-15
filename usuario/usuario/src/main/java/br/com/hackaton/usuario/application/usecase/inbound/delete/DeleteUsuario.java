package br.com.hackaton.usuario.application.usecase.inbound.delete;

import br.com.hackaton.usuario.application.usecase.inbound.UsuarioPort;

public class DeleteUsuario {
    private final UsuarioPort usuarioPort;

    public DeleteUsuario(UsuarioPort usuarioPort) {
        this.usuarioPort = usuarioPort;
    }

    public DeleteUsuarioOutput deleteUsuario (String cpf) {
        return usuarioPort.deleteUsuario(cpf);
    }
}
