package crud.javanauta.cadastro_usuario.controller;

import crud.javanauta.cadastro_usuario.business.PessoaFisicaService;
import crud.javanauta.cadastro_usuario.infrastructure.entitys.PessoaFisica;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping
    public ResponseEntity<PessoaFisica> buscaPessoaFisicaPorId(@RequestParam String id){
        return ResponseEntity.ok(pessoaFisicaService.buscarPessoaFisicaPorId(id));
    }

    @GetMapping("/email")
    public ResponseEntity<PessoaFisica> buscaPessoaFisicaPorEmail(@RequestParam String email){
        return ResponseEntity.ok(pessoaFisicaService.buscarPessoaFisicaPorEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<String> deletaPessoaFisicaPorId(@RequestParam String id){
        pessoaFisicaService.deletarPessoaFisicaPorId(id);
        return ResponseEntity.ok("Cadastro excluído com sucesso!");
    }
}
