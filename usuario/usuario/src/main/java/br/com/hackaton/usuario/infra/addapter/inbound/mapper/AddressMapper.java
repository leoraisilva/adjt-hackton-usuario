package br.com.hackaton.usuario.infra.addapter.inbound.mapper;

import br.com.hackaton.usuario.application.domain.Address;
import br.com.hackaton.usuario.application.domain.AddressFactory;
import br.com.hackaton.usuario.infra.addapter.outbound.persistent.entity.AddressEntity;

public class AddressMapper implements IAddressMapper {
    private final AddressFactory factory;

    public AddressMapper(AddressFactory factory) {
        this.factory = factory;
    }

    public Address toDomain (AddressEntity entity) {
        return factory.novoAddress(
                entity.getCep(),
                entity.getCodigoMunicipal(),
                entity.getLogradouro(),
                entity.getComplemento(),
                entity.getBairro(),
                entity.getLocalidade(),
                entity.getEstado(),
                entity.getUf()
        );
    }

    public AddressEntity toEntity (Address domain) {
        return new AddressEntity(
                domain.getCep(),
                domain.getCodigoMunicipal(),
                domain.getLogradouro(),
                domain.getComplemento(),
                domain.getBairro(),
                domain.getLocalidade(),
                domain.getEstado(),
                domain.getUF()
        );
    }
}
