package crud.javanauta.cadastro_usuario.infrastructure.repository;

import crud.javanauta.cadastro_usuario.infrastructure.entitys.PessoaFisica;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Integer> {

    Optional<PessoaFisica> findByEmail(String email);

    boolean existsByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}
