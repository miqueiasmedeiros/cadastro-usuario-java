package crud.javanauta.cadastro_usuario.controller;

import crud.javanauta.cadastro_usuario.business.MunicipioService;
import crud.javanauta.cadastro_usuario.infrastructure.entitys.Municipio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/municipios")
@RequiredArgsConstructor
public class MunicipioController {
    private final MunicipioService municipioService;

    @GetMapping
    public ResponseEntity<List<Municipio>> listarMunicipios(){
        return ResponseEntity.ok(municipioService.listarMunicipios());
    }
}
