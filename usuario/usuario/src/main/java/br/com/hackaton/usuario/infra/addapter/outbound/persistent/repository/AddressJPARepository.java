package br.com.hackaton.usuario.infra.addapter.outbound.persistent.repository;

import br.com.hackaton.usuario.infra.addapter.outbound.persistent.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressJPARepository extends JpaRepository<AddressEntity, String> {
    Optional<AddressEntity> findByCep(String cep);
}
