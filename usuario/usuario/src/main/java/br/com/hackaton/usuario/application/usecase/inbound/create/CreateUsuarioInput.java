package br.com.hackaton.usuario.application.usecase.inbound.create;

import br.com.hackaton.usuario.application.domain.Address;
import br.com.hackaton.usuario.application.domain.Status;
import br.com.hackaton.usuario.application.domain.Usuario;

public record CreateUsuarioInput (String nome, String cpf, Status status, Address endereco, String tell, String email) {
    public static CreateUsuarioInput from (Usuario usuario) {
        return new CreateUsuarioInput(
                usuario.getNome(),
                usuario.getCpf(),
                usuario.getStatus(),
                usuario.getEndereco(),
                usuario.getTell(),
                usuario.getEmail()
        );
    }
    public static Usuario to (CreateUsuarioInput input) {
        return new Usuario.UsuarioBuilder()
                .withNome(input.nome)
                .withCPF(input.cpf)
                .withStatus(input.status)
                .withCep(input.endereco)
                .withTell(input.tell)
                .withEmail(input.email)
                .build();
    }

}
