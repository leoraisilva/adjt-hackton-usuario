package br.com.hackaton.usuario.infra.outbound.persistent.repository;

import br.com.hackaton.usuario.infra.outbound.persistent.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressJPARepository extends JpaRepository<AddressEntity, String> {
    AddressEntity findByCep(String cep);
}
