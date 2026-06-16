package br.com.hackaton.usuario.infra.addapter.outbound.persistent.repository;

import br.com.hackaton.usuario.infra.addapter.outbound.persistent.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioJPARepository extends JpaRepository<UsuarioEntity, String > {
    Optional<UsuarioEntity> findByCpf(String cpf);
}
