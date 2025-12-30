package crud.javanauta.cadastro_usuario.infrastructure.repository;

import crud.javanauta.cadastro_usuario.infrastructure.entitys.PessoaFisica;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, String> {

    Optional<PessoaFisica> findByEmail(String email);

    boolean existsByInscricaoEstadual_Codigo(String inscricaoEstadual);
    boolean existsByCpf(String cpf);

    @Transactional
    void deleteByEmail(String email);
}
