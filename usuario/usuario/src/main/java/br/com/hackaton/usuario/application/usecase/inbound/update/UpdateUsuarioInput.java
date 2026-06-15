package br.com.hackaton.usuario.application.usecase.inbound.update;

import br.com.hackaton.usuario.application.domain.Address;
import br.com.hackaton.usuario.application.domain.Status;
import br.com.hackaton.usuario.application.domain.Usuario;
import br.com.hackaton.usuario.application.usecase.inbound.create.CreateUsuarioInput;

public record UpdateUsuarioInput (String idUsuario, String nome, String cpf, Status status, Address address, String tell, String email) {
    public static UpdateUsuarioInput from (Usuario usuario, Address address) {
        return new UpdateUsuarioInput(
                usuario.getIdUsuario(),
                usuario.getNome(),
                usuario.getCpf(),
                usuario.getStatus(),
                address,
                usuario.getTell(),
                usuario.getEmail()
        );
    }
    public static Usuario to (UpdateUsuarioInput input) {
        return new Usuario.UsuarioBuilder()
                .withIdUsuario(input.idUsuario())
                .withNome(input.nome)
                .withCPF(input.cpf)
                .withStatus(input.status)
                .withCep(input.address.getCep())
                .withTell(input.tell)
                .withEmail(input.email)
                .build();
    }
}
