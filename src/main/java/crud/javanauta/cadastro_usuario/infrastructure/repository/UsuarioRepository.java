package crud.javanauta.cadastro_usuario.infrastructure.repository;

import crud.javanauta.cadastro_usuario.infrastructure.entitys.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {


    Optional<Usuario> findById(String id);


    @Transactional
    void deleteById(String id);

}
