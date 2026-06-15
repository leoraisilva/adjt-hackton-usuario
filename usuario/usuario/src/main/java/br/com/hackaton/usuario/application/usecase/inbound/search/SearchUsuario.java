package br.com.hackaton.usuario.application.usecase.inbound.search;

import br.com.hackaton.usuario.application.usecase.inbound.UsuarioPort;

public class SearchUsuario {
    private final UsuarioPort usuarioPort;

    public SearchUsuario(UsuarioPort usuarioPort) {
        this.usuarioPort = usuarioPort;
    }

    public SearchUsuarioOutput searchUsuario (String cpf) {
        return usuarioPort.searchUsuario(cpf);
    }
}
