package br.com.hackaton.usuario.infra.addapter.inbound.mapper;

import br.com.hackaton.usuario.application.domain.Usuario;
import br.com.hackaton.usuario.application.domain.UsuarioFactory;
import br.com.hackaton.usuario.infra.addapter.outbound.persistent.entity.UsuarioEntity;

public class UsuarioMapper implements IUsuarioMapper{
    private final UsuarioFactory factory;

    public UsuarioMapper(UsuarioFactory factory) {
        this.factory = factory;
    }

    public Usuario toDomain (UsuarioEntity entity) {
        return factory.novoUsuario(
                entity.getIdUsuario(),
                entity.getNome(),
                entity.getStatus(),
                entity.getCpf(),
                entity.getCep(),
                entity.getTell(),
                entity.getEmail()
        );
    }

    public UsuarioEntity toEntity (Usuario domain) {
        return new UsuarioEntity(
                domain.getIdUsuario(),
                domain.getNome(),
                domain.getCpf(),
                domain.getStatus(),
                domain.getCep(),
                domain.getTell(),
                domain.getEmail()
        );
    }
}
