package br.com.hackaton.usuario.application.usecase.inbound;

import br.com.hackaton.usuario.application.domain.Address;
import br.com.hackaton.usuario.application.usecase.inbound.create.CreateUsuarioInput;
import br.com.hackaton.usuario.application.usecase.inbound.create.CreateUsuarioOutput;
import br.com.hackaton.usuario.application.usecase.inbound.delete.DeleteUsuarioOutput;
import br.com.hackaton.usuario.application.usecase.inbound.list.ListUsuarioOutput;
import br.com.hackaton.usuario.application.usecase.inbound.search.SearchUsuarioOutput;
import br.com.hackaton.usuario.application.usecase.inbound.update.UpdateUsuarioInput;
import br.com.hackaton.usuario.application.usecase.inbound.update.UpdateUsuarioOutput;

import java.util.List;

public interface UsuarioPort {
    CreateUsuarioOutput createUsuario (CreateUsuarioInput input);
    DeleteUsuarioOutput deleteUsuario (String cpf);
    List<ListUsuarioOutput> listUsuario ();
    SearchUsuarioOutput searchUsuario (String cpf);
    UpdateUsuarioOutput updateUsuario (UpdateUsuarioInput input);
}
