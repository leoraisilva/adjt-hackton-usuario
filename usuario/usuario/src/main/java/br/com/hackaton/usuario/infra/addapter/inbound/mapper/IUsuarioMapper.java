package br.com.hackaton.usuario.infra.addapter.inbound.mapper;

import br.com.hackaton.usuario.application.domain.Usuario;
import br.com.hackaton.usuario.infra.addapter.outbound.persistent.entity.UsuarioEntity;

public interface IUsuarioMapper {
    Usuario toDomain (UsuarioEntity entity);
    UsuarioEntity toEntity (Usuario domain);
}
