package br.com.hackaton.usuario.infra.inbound.mapper;

import br.com.hackaton.usuario.application.domain.Usuario;
import br.com.hackaton.usuario.infra.outbound.persistent.entity.UsuarioEntity;

public interface IUsuarioMapper {
    Usuario toDomain (UsuarioEntity entity);
    UsuarioEntity toEntity (Usuario domain);
}
