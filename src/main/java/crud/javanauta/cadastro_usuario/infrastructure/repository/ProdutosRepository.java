package crud.javanauta.cadastro_usuario.infrastructure.repository;

import crud.javanauta.cadastro_usuario.infrastructure.entitys.Produto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutosRepository extends JpaRepository<Produto, Integer> {

    Optional<Produto> findById(Integer id);

    @Transactional
    void deleteById(Integer id);
}
