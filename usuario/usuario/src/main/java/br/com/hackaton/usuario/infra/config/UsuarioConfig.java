package br.com.hackaton.usuario.infra.config;

import br.com.hackaton.usuario.application.domain.AddressFactory;
import br.com.hackaton.usuario.application.domain.DefaultAddressFactory;
import br.com.hackaton.usuario.application.domain.DefaultUsuarioFactory;
import br.com.hackaton.usuario.application.domain.UsuarioFactory;
import br.com.hackaton.usuario.application.service.UsuarioService;
import br.com.hackaton.usuario.application.usecase.inbound.UsuarioPort;
import br.com.hackaton.usuario.application.usecase.inbound.create.CreateUsuario;
import br.com.hackaton.usuario.application.usecase.inbound.delete.DeleteUsuario;
import br.com.hackaton.usuario.application.usecase.inbound.list.ListUsuario;
import br.com.hackaton.usuario.application.usecase.inbound.search.SearchUsuario;
import br.com.hackaton.usuario.application.usecase.inbound.update.UpdateUsuario;
import br.com.hackaton.usuario.application.usecase.outbound.UsuarioRepository;
import br.com.hackaton.usuario.infra.addapter.gateway.UsuarioImplRepository;
import br.com.hackaton.usuario.infra.addapter.inbound.mapper.AddressMapper;
import br.com.hackaton.usuario.infra.addapter.inbound.mapper.IAddressMapper;
import br.com.hackaton.usuario.infra.addapter.inbound.mapper.IUsuarioMapper;
import br.com.hackaton.usuario.infra.addapter.inbound.mapper.UsuarioMapper;
import br.com.hackaton.usuario.infra.addapter.outbound.persistent.repository.AddressJPARepository;
import br.com.hackaton.usuario.infra.addapter.outbound.persistent.repository.UsuarioJPARepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    UpdateUsuario updateUsuario(UsuarioPort usuarioPort) {
        return new UpdateUsuario(usuarioPort);
    }

    @Bean
    ListUsuario listUsuario(UsuarioPort usuarioPort) {
        return new ListUsuario(usuarioPort);
    }

    @Bean
    CreateUsuario createUsuario(UsuarioPort usuarioPort) {
        return new CreateUsuario(usuarioPort);
    }

    @Bean
    DeleteUsuario deleteUsuario(UsuarioPort usuarioPort) {
        return new DeleteUsuario(usuarioPort);
    }

    @Bean
    SearchUsuario searchUsuario(UsuarioPort usuarioPort) {
        return new SearchUsuario(usuarioPort);
    }

    @Bean
    UsuarioPort usuarioPort(UsuarioRepository usuarioRepository) {
        return new UsuarioService(usuarioRepository);
    }

    @Bean
    UsuarioRepository usuarioRepository(UsuarioJPARepository usuarioJPARepository, AddressJPARepository addressJPARepository, IAddressMapper addressMapper, IUsuarioMapper usuarioMapper) {
        return new UsuarioImplRepository(usuarioJPARepository, addressJPARepository, addressMapper, usuarioMapper);
    }

    @Bean
    IUsuarioMapper usuarioMapper (UsuarioFactory usuarioFactory) {
        return new UsuarioMapper(usuarioFactory);
    }

    @Bean
    IAddressMapper addressMapper (AddressFactory addressFactory) {
        return new AddressMapper(addressFactory);
    }

    @Bean
    UsuarioFactory usuarioFactory() {
        return new DefaultUsuarioFactory();
    }

    @Bean
    AddressFactory addressFactory() {
        return new DefaultAddressFactory();
    }
}
