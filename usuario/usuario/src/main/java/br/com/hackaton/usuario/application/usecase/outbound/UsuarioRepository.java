package br.com.hackaton.usuario.application.usecase.outbound;

import br.com.hackaton.usuario.application.domain.Address;
import br.com.hackaton.usuario.application.domain.Usuario;
import br.com.hackaton.usuario.infra.outbound.persistent.entity.UsuarioEntity;

import java.util.List;

public interface UsuarioRepository {
    UsuarioEntity createUsuario (Usuario usuario);
    Usuario deleteUsuario (String cpf);
    List<Usuario> listUsuario ();
    Usuario searchUsuario (String cpf);
    Usuario updateUsuario (Usuario usuario);
    Address searchAddress (String cep);
}
