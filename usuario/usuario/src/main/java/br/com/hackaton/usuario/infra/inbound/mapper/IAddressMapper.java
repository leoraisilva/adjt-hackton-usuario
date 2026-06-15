package br.com.hackaton.usuario.infra.inbound.mapper;

import br.com.hackaton.usuario.application.domain.Address;
import br.com.hackaton.usuario.infra.outbound.persistent.entity.AddressEntity;

public interface IAddressMapper {
    Address toDomain (AddressEntity entity);
    AddressEntity toEntity (Address domain);
}
