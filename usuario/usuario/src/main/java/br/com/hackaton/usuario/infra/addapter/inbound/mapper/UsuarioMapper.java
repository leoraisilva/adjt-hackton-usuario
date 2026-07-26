package br.com.hackaton.usuario.infra.addapter.inbound.mapper;

import br.com.hackaton.usuario.application.domain.*;
import br.com.hackaton.usuario.infra.addapter.outbound.persistent.entity.AddressEntity;
import br.com.hackaton.usuario.infra.addapter.outbound.persistent.entity.UsuarioEntity;

public class UsuarioMapper implements IUsuarioMapper{
    private final UsuarioFactory usuarioFactory;
    private final AddressFactory addressFactory;

    public UsuarioMapper(UsuarioFactory usuarioFactory, AddressFactory addressFactory) {
        this.usuarioFactory = usuarioFactory;
        this.addressFactory = addressFactory;
    }

    public Usuario toDomain (UsuarioEntity entity) {
        return usuarioFactory.novoUsuario(
                entity.getIdUsuario(),
                entity.getNome(),
                Status.valueOf(entity.getStatus()),
                entity.getCpf(),
                addressFactory.novoAddress(
                        entity.getEndereco().getCep(),
                        entity.getEndereco().getCodigoMunicipal(),
                        entity.getEndereco().getLogradouro(),
                        entity.getEndereco().getComplemento(),
                        entity.getEndereco().getBairro(),
                        entity.getEndereco().getLocalidade(),
                        entity.getEndereco().getEstado(),
                        entity.getEndereco().getUf()
                ),
                entity.getTell(),
                entity.getEmail()
        );
    }

    public UsuarioEntity toEntity (Usuario domain) {
        return new UsuarioEntity(
                domain.getIdUsuario(),
                domain.getNome(),
                domain.getCpf(),
                domain.getStatus().name(),
                new AddressEntity(
                        domain.getEndereco().getCep(),
                        domain.getEndereco().getCodigoMunicipal(),
                        domain.getEndereco().getLogradouro(),
                        domain.getEndereco().getComplemento(),
                        domain.getEndereco().getBairro(),
                        domain.getEndereco().getLocalidade(),
                        domain.getEndereco().getEstado(),
                        domain.getEndereco().getUF()
                ),
                domain.getTell(),
                domain.getEmail()
        );
    }
}
