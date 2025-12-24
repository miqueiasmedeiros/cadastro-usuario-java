package crud.javanauta.cadastro_usuario.controller;

import crud.javanauta.cadastro_usuario.business.UsuarioService;
import crud.javanauta.cadastro_usuario.infrastructure.entitys.Usuario;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario){
       Usuario usuarioSalvo = usuarioService.salvarUsuario(usuario);
       return ResponseEntity.ok(usuarioSalvo);
    }
    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarioPorId(@RequestParam String id){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorId(id));
    }
//    @GetMapping
//    public ResponseEntity<Usuario> buscarUsuarioPorId(@RequestParam Integer id){
//        return ResponseEntity.ok(usuarioService.buscarUsuarioPorId(id));
//    }
    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorId(@RequestParam String id){
        usuarioService.deletarUsuarioPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Usuario> atualizarUsuarioPorId(@RequestParam String id,
                                                      @RequestBody Usuario usuario){
      Usuario usuarioAtualizado =  usuarioService.atualizarUsuarioPorId(id, usuario);
        return ResponseEntity.ok(usuarioAtualizado);
    }
}
