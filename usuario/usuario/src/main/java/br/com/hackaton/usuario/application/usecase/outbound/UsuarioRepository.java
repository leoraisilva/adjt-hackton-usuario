package br.com.hackaton.usuario.application.usecase.outbound;

import br.com.hackaton.usuario.application.domain.Address;
import br.com.hackaton.usuario.application.domain.Usuario;

import java.util.List;

public interface UsuarioRepository {
    Usuario createUsuario (Usuario usuario);
    Usuario deleteUsuario (String cpf);
    List<Usuario> listUsuario ();
    Usuario searchUsuario (String cpf);
    Usuario updateUsuario (Usuario usuario);
    Address searchAddress (String cep);
    Address createAddress (Address address);
    Address updateAddress (Address address);
}
