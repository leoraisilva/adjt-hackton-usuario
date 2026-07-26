package br.com.hackaton.usuario.application.usecase.inbound.update;

import br.com.hackaton.usuario.application.domain.Address;
import br.com.hackaton.usuario.application.domain.Status;
import br.com.hackaton.usuario.application.domain.Usuario;
import br.com.hackaton.usuario.application.usecase.inbound.create.CreateUsuarioInput;

public record UpdateUsuarioInput (String nome, String cpf, Status status, Address address, String tell, String email) {
    public static UpdateUsuarioInput from (Usuario usuario) {
        return new UpdateUsuarioInput(
                usuario.getNome(),
                usuario.getCpf(),
                usuario.getStatus(),
                usuario.getEndereco(),
                usuario.getTell(),
                usuario.getEmail()
        );
    }
    public static Usuario to (UpdateUsuarioInput input) {
        return new Usuario.UsuarioBuilder()
                .withNome(input.nome)
                .withCPF(input.cpf)
                .withStatus(input.status)
                .withCep(input.address)
                .withTell(input.tell)
                .withEmail(input.email)
                .build();
    }
}
