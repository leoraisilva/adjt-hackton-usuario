package br.com.hackaton.usuario.application.usecase.inbound.create;

import br.com.hackaton.usuario.application.usecase.inbound.UsuarioPort;

public class CreateUsuario {
    private final UsuarioPort usuarioPort;

    public CreateUsuario(UsuarioPort usuarioPort) {
        this.usuarioPort = usuarioPort;
    }

    public CreateUsuarioOutput createUsuario (CreateUsuarioInput input) {
        return usuarioPort.createUsuario(input);
    }
}
