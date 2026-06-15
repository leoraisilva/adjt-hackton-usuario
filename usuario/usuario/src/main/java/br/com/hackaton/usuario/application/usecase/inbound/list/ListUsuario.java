package br.com.hackaton.usuario.application.usecase.inbound.list;

import br.com.hackaton.usuario.application.usecase.inbound.UsuarioPort;
import br.com.hackaton.usuario.application.usecase.inbound.delete.DeleteUsuarioOutput;

import java.util.List;

public class ListUsuario {
    private final UsuarioPort usuarioPort;

    public ListUsuario(UsuarioPort usuarioPort) {
        this.usuarioPort = usuarioPort;
    }

    public List<ListUsuarioOutput> listUsuario () {
        return usuarioPort.listUsuario();
    }
}
