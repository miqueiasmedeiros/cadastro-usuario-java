package crud.javanauta.cadastro_usuario.controller;

import crud.javanauta.cadastro_usuario.business.PessoaFisicaService;
import crud.javanauta.cadastro_usuario.infrastructure.entitys.PessoaFisica;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastro")
@RequiredArgsConstructor
public class PessoaFisicaController {

    private final PessoaFisicaService pessoaFisicaService;

    @PostMapping
    public ResponseEntity<PessoaFisica> salvarPessoaFisica(@RequestBody PessoaFisica pessoaFisica){
        PessoaFisica pfSalvo = pessoaFisicaService.salvarPessoaFisica(pessoaFisica);
        return ResponseEntity.ok(pfSalvo);
    }
}
