package crud.javanauta.cadastro_usuario.controller;

import crud.javanauta.cadastro_usuario.business.PessoaFisicaService;
import crud.javanauta.cadastro_usuario.controller.dto.PessoaFisicaDTO;
import crud.javanauta.cadastro_usuario.infrastructure.entitys.PessoaFisica;
import crud.javanauta.cadastro_usuario.infrastructure.repository.PessoaFisicaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas-fisicas")
@RequiredArgsConstructor
public class PessoaFisicaController {

    private final PessoaFisicaService pessoaFisicaService;
    private final PessoaFisicaRepository pessoaFisicaRepository;

    @Operation(
            summary = "Cadastro de Pessoa Física",
            description = "Cria um novo cadastro de Pessoa Física no sistema",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Cadastro realizado com sucesso"),
                    @ApiResponse(responseCode = "400", description = "CPF já cadastrado ou dados inválidos" )
            }
    )

    @PostMapping
    public ResponseEntity<PessoaFisica> salvarPessoaFisica(@RequestBody PessoaFisicaDTO pessoaFisica){
        PessoaFisica pfSalvo = pessoaFisicaService.salvarPessoaFisica(pessoaFisica);
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(pfSalvo);
    }
    @Operation(
            summary = "Buscar Pessoa Física por ID",
            description = "Retorna os dados de uma Pessoa Física pelo ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Cadastro encontrado"),
                    @ApiResponse(responseCode = "404", description = "Id do Cadastro não encontrado")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<PessoaFisica> buscaPessoaFisicaPorId(
                                          @Parameter(
                                                  description = "ID da Pessoa Física",
                                                  example = "uuid-123",
                                                  required = true  )
                                          @PathVariable String id
                                          )
    {
        return ResponseEntity.ok(pessoaFisicaService.buscarPessoaFisicaPorId(id));
    }
    @Operation(
            summary = "Buscar Pessoa Física por e-mail",
            description = "Retorna os dados de uma Pessoa Física pelo e-mail",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Cadastro encontrado"),
                    @ApiResponse(responseCode = "404", description = "Cadastro não encontrado")
            }
    )
    @GetMapping("/email")
    public ResponseEntity<PessoaFisica> buscaPessoaFisicaPorEmail(
            @Parameter(description = "E-mail da Pessoa Física", example = "email@dominio.com")
            @RequestParam String email){
        return ResponseEntity.ok(pessoaFisicaService.buscarPessoaFisicaPorEmail(email));
    }

    @Operation(
            summary = "Excluir Pessoa Física Por Id",
            description = "Remove o cadastro de uma Pessoa Física pelo ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Cadastro excluído com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Cadastro não encontrado")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletaPessoaFisicaPorId(
            @Parameter(description = "ID da Pessoa Física", example = "uuid-123")
            @PathVariable String id){
        pessoaFisicaService.deletarPessoaFisicaPorId(id);
        return ResponseEntity.ok("Cadastro excluído com sucesso!");
    }
    @GetMapping
    public ResponseEntity<List<PessoaFisica>> listarPessoasFisicas()
    {
        return ResponseEntity.ok(pessoaFisicaRepository.findAll());
    }
}
