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
    private final IAddressMapper addressMapper;
    private final IUsuarioMapper usuarioMapper;

    public UsuarioImplRepository(UsuarioJPARepository usuarioJPARepository, AddressJPARepository addressJPARepository, IAddressMapper addressMapper, IUsuarioMapper usuarioMapper) {
        this.usuarioJPARepository = usuarioJPARepository;
        this.addressJPARepository = addressJPARepository;
        this.addressMapper = addressMapper;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        var address = addressJPARepository.findByCep(usuario.getCep());
        return usuarioMapper.toDomain(usuarioJPARepository.save(usuarioMapper.toEntity(usuario)));
    }

    @Override
    public Usuario deleteUsuario(String cpf) {
        var usuarioEntity = usuarioJPARepository.findByCpf(cpf).orElseThrow(() -> new RuntimeException("Not found Usuario!!"));
        usuarioEntity.setStatus(Status.INATIVO);
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
        return usuarioMapper.toDomain(usuarioJPARepository.findByCpf(cpf).orElseThrow(() -> new RuntimeException("Not found Usuario!!")));
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        var usuarioEntity = usuarioJPARepository.findByCpf(usuario.getCpf()).orElseThrow(() -> new RuntimeException("Not found Usuario!!"));
        usuarioEntity.setCpf(usuario.getCpf());
        usuarioEntity.setNome(usuario.getNome());
        usuarioEntity.setTell(usuario.getTell());
        usuarioEntity.setEmail(usuario.getEmail());
        return usuarioMapper.toDomain(usuarioJPARepository.save(usuarioEntity));
    }

    @Override
    public Address searchAddress(String cep) {
        return addressMapper.toDomain(addressJPARepository.findByCep(cep).orElse(new AddressEntity()));
    }

    @Override
    public Address createAddress(Address address) {
        return addressMapper.toDomain(addressJPARepository.save(addressMapper.toEntity(address)));
    }

    @Override
    public Address updateAddress(Address address) {
        var addressEntity = addressJPARepository.findByCep(address.getCep()).orElseThrow(() -> new RuntimeException("Not Found Address!!"));
        addressEntity.setBairro(address.getBairro());
        addressEntity.setEstado(address.getEstado());
        addressEntity.setComplemento(address.getComplemento());
        addressEntity.setIbge(address.getIbge());
        addressEntity.setLogradouro(address.getLogradouro());
        addressEntity.setLocalidade(address.getLocalidade());
        addressEntity.setUf(address.getUF());
        return addressMapper.toDomain(addressJPARepository.save(addressEntity));
    }
}
