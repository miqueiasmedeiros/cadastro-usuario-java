package crud.javanauta.cadastro_usuario.infrastructure.repository;

import crud.javanauta.cadastro_usuario.infrastructure.entitys.UF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UFRepository extends JpaRepository<UF, String> {
}
