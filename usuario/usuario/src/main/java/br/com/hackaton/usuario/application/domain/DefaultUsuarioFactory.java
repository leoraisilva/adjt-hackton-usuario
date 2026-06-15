package br.com.hackaton.usuario.application.domain;

public class DefaultUsuarioFactory implements UsuarioFactory {
    @Override
    public Usuario novoUsuario(String idUsuario, String nome, Status status, String cpf, String cep, String tell, String email) {
        return new Usuario.UsuarioBuilder()
                .withIdUsuario(idUsuario)
                .withNome(nome)
                .withCPF(cpf)
                .withStatus(status)
                .withCep(cep)
                .withTell(tell)
                .withEmail(email)
                .build();
    }
}
