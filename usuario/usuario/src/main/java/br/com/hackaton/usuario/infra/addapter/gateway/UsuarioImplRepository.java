package br.com.hackaton.usuario.infra.addapter.gateway;

import br.com.hackaton.usuario.application.domain.Address;
import br.com.hackaton.usuario.application.domain.Status;
import br.com.hackaton.usuario.application.domain.Usuario;
import br.com.hackaton.usuario.application.usecase.outbound.UsuarioRepository;
import br.com.hackaton.usuario.infra.addapter.inbound.mapper.IAddressMapper;
import br.com.hackaton.usuario.infra.addapter.inbound.mapper.IUsuarioMapper;
import br.com.hackaton.usuario.infra.addapter.outbound.persistent.entity.AddressEntity;
import br.com.hackaton.usuario.infra.addapter.outbound.persistent.repository.AddressJPARepository;
import br.com.hackaton.usuario.infra.addapter.outbound.persistent.repository.UsuarioJPARepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioImplRepository implements UsuarioRepository {
    private final UsuarioJPARepository usuarioJPARepository;
    private final AddressJPARepository addressJPARepository;
    private final IUsuarioMapper usuarioMapper;

    public UsuarioImplRepository(UsuarioJPARepository usuarioJPARepository, AddressJPARepository addressJPARepository, IUsuarioMapper usuarioMapper) {
        this.usuarioJPARepository = usuarioJPARepository;
        this.addressJPARepository = addressJPARepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        var addressEntity = addressJPARepository.findByCep(usuario.getEndereco().getCep()).orElseGet(AddressEntity::new);
        addressEntity.setCep(usuario.getEndereco().getCep());
        addressEntity.setCodigoMunicipal(usuario.getEndereco().getCodigoMunicipio());
        addressEntity.setBairro(usuario.getEndereco().getBairro());
        addressEntity.setEstado(usuario.getEndereco().getEstado());
        addressEntity.setLogradouro(usuario.getEndereco().getLogradouro());
        addressEntity.setLocalidade(usuario.getEndereco().getLocalidade());
        addressEntity.setComplemento(usuario.getEndereco().getComplemento());
        addressEntity.setUf(usuario.getEndereco().getUF());
        addressEntity = addressJPARepository.save(addressEntity);

        var usuarioEntity = usuarioMapper.toEntity(usuario);
        usuarioEntity.setEndereco(addressEntity);
        return usuarioMapper.toDomain(usuarioJPARepository.save(usuarioEntity));
    }

    @Override
    public Usuario deleteUsuario(String cpf) {
        var usuarioEntity = usuarioJPARepository.findByCpf(cpf).orElseThrow(() -> new RuntimeException("Not Found Usuario!!"));
        usuarioEntity.setStatus(Status.INATIVO.name());
        return usuarioMapper.toDomain(usuarioJPARepository.save(usuarioEntity));
    }

    @Override
    public List<Usuario> listUsuario() {
        return usuarioJPARepository.findAll().stream()
                .map(usuarioMapper::toDomain)
                .toList();
    }

    @Override
    public Usuario searchUsuario(String cpf) {
        var usuarioEntity = usuarioJPARepository.findByCpf(cpf).orElseThrow(() -> new RuntimeException("Not Found Usuario !!"));
        return usuarioMapper.toDomain(usuarioEntity);
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        var addressEntity = addressJPARepository.findByCep(usuario.getEndereco().getCep()).orElseGet(AddressEntity::new);
        addressEntity.setCep(usuario.getEndereco().getCep());
        addressEntity.setCodigoMunicipal(usuario.getEndereco().getCodigoMunicipio());
        addressEntity.setBairro(usuario.getEndereco().getBairro());
        addressEntity.setEstado(usuario.getEndereco().getEstado());
        addressEntity.setLogradouro(usuario.getEndereco().getLogradouro());
        addressEntity.setLocalidade(usuario.getEndereco().getLocalidade());
        addressEntity.setComplemento(usuario.getEndereco().getComplemento());
        addressEntity.setUf(usuario.getEndereco().getUF());
        addressEntity = addressJPARepository.save(addressEntity);

        var usuarioEntity = usuarioJPARepository.findByCpf(usuario.getCpf()).orElseThrow(() -> new RuntimeException("Not Found Usuario!!"));
        usuarioEntity.setCpf(usuario.getCpf());
        usuarioEntity.setStatus(usuario.getStatus().name());
        usuarioEntity.setNome(usuario.getNome());
        usuarioEntity.setEmail(usuario.getEmail());
        usuarioEntity.setTell(usuario.getTell());
        usuarioEntity.setEndereco(addressEntity);
        return usuarioMapper.toDomain(usuarioJPARepository.save(usuarioEntity));
    }
}
