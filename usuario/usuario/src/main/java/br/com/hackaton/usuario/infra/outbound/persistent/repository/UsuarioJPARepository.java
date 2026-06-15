package br.com.hackaton.usuario.infra.outbound.persistent.repository;

import br.com.hackaton.usuario.infra.outbound.persistent.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioJPARepository extends JpaRepository<UsuarioEntity, String > {
    UsuarioEntity findByCpf(String cpf);
}
