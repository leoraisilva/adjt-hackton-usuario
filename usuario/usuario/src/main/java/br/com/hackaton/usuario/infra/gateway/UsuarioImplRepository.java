package br.com.hackaton.usuario.infra.gateway;

import br.com.hackaton.usuario.application.domain.Address;
import br.com.hackaton.usuario.application.domain.Usuario;
import br.com.hackaton.usuario.application.usecase.outbound.UsuarioRepository;
import br.com.hackaton.usuario.infra.inbound.mapper.IAddressMapper;
import br.com.hackaton.usuario.infra.inbound.mapper.IUsuarioMapper;
import br.com.hackaton.usuario.infra.outbound.persistent.entity.UsuarioEntity;
import br.com.hackaton.usuario.infra.outbound.persistent.repository.AddressJPARepository;
import br.com.hackaton.usuario.infra.outbound.persistent.repository.UsuarioJPARepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioImplRepository implements UsuarioRepository {
    private final UsuarioJPARepository usuarioJPARepository;
    private final AddressJPARepository addressJPARepository;
    private final IAddressMapper addressMapper;
    private final IUsuarioMapper usuarioMapper;

    public UsuarioImplRepository(UsuarioJPARepository usuarioJPARepository, AddressJPARepository addressJPARepository, IAddressMapper addressMapper, IUsuarioMapper usuarioMapper) {
        this.usuarioJPARepository = usuarioJPARepository;
        this.addressJPARepository = addressJPARepository;
        this.addressMapper = addressMapper;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public UsuarioEntity createUsuario(Usuario usuario) {
        return usuarioJPARepository.save(usuarioMapper.toEntity(usuario));
    }

    @Override
    public Usuario deleteUsuario(String cpf) {
        return null;
    }

    @Override
    public List<Usuario> listUsuario() {
        return List.of();
    }

    @Override
    public Usuario searchUsuario(String cpf) {
        return null;
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public Address searchAddress(String cep) {
        return null;
    }
}
