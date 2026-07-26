package br.com.hackaton.usuario.application.service;

import br.com.hackaton.usuario.application.domain.Address;
import br.com.hackaton.usuario.application.usecase.inbound.UsuarioPort;
import br.com.hackaton.usuario.application.usecase.inbound.create.CreateUsuarioInput;
import br.com.hackaton.usuario.application.usecase.inbound.create.CreateUsuarioOutput;
import br.com.hackaton.usuario.application.usecase.inbound.delete.DeleteUsuarioOutput;
import br.com.hackaton.usuario.application.usecase.inbound.list.ListUsuarioOutput;
import br.com.hackaton.usuario.application.usecase.inbound.search.SearchUsuarioOutput;
import br.com.hackaton.usuario.application.usecase.inbound.update.UpdateUsuarioInput;
import br.com.hackaton.usuario.application.usecase.inbound.update.UpdateUsuarioOutput;
import br.com.hackaton.usuario.application.usecase.outbound.UsuarioRepository;

import java.util.List;

public class UsuarioService implements UsuarioPort {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreateUsuarioOutput createUsuario(CreateUsuarioInput input) {
        return CreateUsuarioOutput.from(repository.createUsuario(CreateUsuarioInput.to(input)));
    }

    @Override
    public DeleteUsuarioOutput deleteUsuario(String cpf) {
        return DeleteUsuarioOutput.from(repository.deleteUsuario(cpf));
    }

    @Override
    public List<ListUsuarioOutput> listUsuario() {
        return repository.listUsuario().stream()
                .map(ListUsuarioOutput::from)
                .toList();
    }

    @Override
    public SearchUsuarioOutput searchUsuario(String cpf) {
        return SearchUsuarioOutput.from(repository.searchUsuario(cpf));
    }

    @Override
    public UpdateUsuarioOutput updateUsuario(UpdateUsuarioInput input) {
        return UpdateUsuarioOutput.from(repository.updateUsuario(UpdateUsuarioInput.to(input)));
    }
}
