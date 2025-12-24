package crud.javanauta.cadastro_usuario.business;

import crud.javanauta.cadastro_usuario.infrastructure.entitys.PessoaFisica;
import crud.javanauta.cadastro_usuario.infrastructure.entitys.Usuario;
import crud.javanauta.cadastro_usuario.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario salvarUsuario(Usuario usuario){
        usuario.setId(UUID.randomUUID().toString());
        repository.saveAndFlush(usuario);
        return usuario;
    }

    public Usuario buscarUsuarioPorId(String id){
        return repository.findById(id).orElseThrow(
                ()-> new RuntimeException("Usuário não Encontrado!")
        );
    }

    public void deletarUsuarioPorId(String id){
        repository.deleteById(id);
    }

    public Usuario atualizarUsuarioPorId(String id, Usuario usuario) {
       Usuario usuarioEntity = repository.findById(id).orElseThrow(()-> new RuntimeException("Usuário não encontrado"));
       Usuario usuarioAtualizado = Usuario.builder()
               .login(usuario.getLogin() != null ? usuario.getLogin():usuarioEntity.getLogin())
               .senha(usuario.getSenha()!=null ? usuario.getSenha():usuarioEntity.getSenha())
               .id(usuario.getId())
               .build();
       repository.saveAndFlush(usuarioAtualizado);
       return usuarioEntity;
    }
}
