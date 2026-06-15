package br.com.hackaton.usuario.application.usecase.inbound.update;

import br.com.hackaton.usuario.application.usecase.inbound.UsuarioPort;

public class UpdateUsuario {
    private final UsuarioPort usuarioPort;

    public UpdateUsuario(UsuarioPort usuarioPort) {
        this.usuarioPort = usuarioPort;
    }

    public UpdateUsuarioOutput deleteUsuario (UpdateUsuarioInput input) {
        return usuarioPort.updateUsuario(input);
    }
}
