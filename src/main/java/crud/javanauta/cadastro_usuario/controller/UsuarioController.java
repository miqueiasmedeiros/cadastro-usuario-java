//package crud.javanauta.cadastro_usuario.controller;
//
//import crud.javanauta.cadastro_usuario.business.UsuarioService;
//import crud.javanauta.cadastro_usuario.infrastructure.entitys.Usuario;
//import lombok.NonNull;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.net.URI;
//
//@RestController
//@RequestMapping("/usuario")
//@RequiredArgsConstructor
//public class UsuarioController {
//
//    private final UsuarioService usuarioService;
//
//    @PostMapping
//    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario){
//        usuarioService.salvarUsuario(usuario);
//        URI location = URI.create("/usuario/");
//        return ResponseEntity.created(location).build();
//    }
//    @GetMapping
//    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam String email){
//        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
//    }
////    @GetMapping
////    public ResponseEntity<Usuario> buscarUsuarioPorId(@RequestParam Integer id){
////        return ResponseEntity.ok(usuarioService.buscarUsuarioPorId(id));
////    }
//    @DeleteMapping
//    public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam String email){
//        usuarioService.deletarUsuarioPorEmail(email);
//        return ResponseEntity.ok().build();
//    }
//
//    @PutMapping
//    public ResponseEntity<Void> atualizarUsuarioPorId(@RequestParam Integer id,
//                                                      @RequestBody Usuario usuario){
//        usuarioService.atualizarUsuarioPorId(id, usuario);
//        return ResponseEntity.ok().build();
//    }
//}
