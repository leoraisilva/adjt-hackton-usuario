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
        if (searchAddress(input.address().getCep()).getCep() == null) repository.createAddress(input.address());
        return CreateUsuarioOutput.from(repository.createUsuario(CreateUsuarioInput.to(input)), input.address());
    }

    @Override
    public DeleteUsuarioOutput deleteUsuario(String cpf) {
        var usuario = repository.deleteUsuario(cpf);
        return DeleteUsuarioOutput.from(usuario, repository.searchAddress(usuario.getCep()));
    }

    @Override
    public List<ListUsuarioOutput> listUsuario() {
        return repository.listUsuario().stream()
                .map(c -> ListUsuarioOutput.from(c, searchAddress(c.getCep())))
                .toList();
    }

    @Override
    public SearchUsuarioOutput searchUsuario(String cpf) {
        var usuario = repository.searchUsuario(cpf);
        var address = repository.searchAddress(usuario.getCep());
        return SearchUsuarioOutput.from(usuario, address);
    }

    @Override
    public UpdateUsuarioOutput updateUsuario(UpdateUsuarioInput input) {
        if (searchAddress(input.address().getCep()).getCep() == null) repository.createAddress(input.address());
        else repository.updateAddress(input.address());
        return UpdateUsuarioOutput.from(repository.updateUsuario(UpdateUsuarioInput.to(input)), input.address());
    }

    private Address searchAddress (String cep) {
        return repository.searchAddress(cep);
    }
}
