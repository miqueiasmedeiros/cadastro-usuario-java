package crud.javanauta.cadastro_usuario.infrastructure.entitys;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PessoaFisica{

    @Id
    private String id;

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

    @ManyToOne
    private Municipio municipio;

    @Column(nullable = false) // Não deixa este campo ser nulo
    @Schema(description = "Nome completo", example = "João da Silva")
    private String nome;

    @Column(nullable = false)
    @Schema(description = "E-mail", example = "joao@email.com")
    private String email;

    @Column(nullable = false,  unique = true)
    @Schema(description = "CPF da pessoa física", example = "12345678900")
    private String cpf;

    @Schema(description = "Telefone", example = "11999999999")
    private String telefone;

     // Se habilitado NFe ou NFCe
    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "codigo", column = @Column(name = "inscricao_estadual"))
    )
    private InscricaoContribuinte inscricaoEstadual;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @Schema(description = "SIMPLES_NACIONAL_MEI(0), REGIME_NORMAL(1), LUCRO_REAL(2)")
    private RegimeTributario regimeTributario;

    public PessoaFisica(String nome,
                        String cpf,
                        String email,
                        String senha,
                        String telefone,
                        String inscricaoEstadual,
                        String regimeTributario,
                        Municipio municipio){
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.municipio = municipio;

        if (inscricaoEstadual!= null){
        this.inscricaoEstadual = new InscricaoContribuinte(inscricaoEstadual);
        }
        this.regimeTributario = RegimeTributario.valueOf(regimeTributario); // CAST conversão literal
        this.usuario = new Usuario(this.cpf, senha);
    }

    // Criar testes com base nesta classe, entendendo conceito de TDD.
    // Criar construtor de Pessoa Física completo, login e senha, com regras de obrigatoriedade,

    /*

    Nome*
CPF*
Email*
Telefone
Inscrição Estadual / Se emissor de NFe/NFCe*
Codigo do Municipio*
Nome do Município
UF*
Regime Tribtário*
    *
    * */


//    @Embedded
//    private Usuario usuario;

//    PessoaFisica pf = new PessoaFisica();
//    String email = pf.getUsuario().getEmail();

//    private String conta;
//
//    private String agencia;

////    @Override
////    // Aqui seta o benefício que eu atribuir.......
////    public String getBeneficios(){
////        return "Eu sou outra mensangem!";
//    }

}
