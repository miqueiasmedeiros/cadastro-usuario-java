package crud.javanauta.cadastro_usuario.infrastructure.entitys;

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

    @OneToOne
    private Usuario usuario;

    @ManyToOne
    private Municipio municipio;

    @Column(nullable = false) // Não deixa este campo ser nulo
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false,  unique = true)
    private String cpf;

    private String telefone;

     // Se habilitado NFe ou NFCe
    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "codigo", column = @Column(name = "inscricao_estadual"))
    )
    private InscricaoContribuinte inscricaoEstadual;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RegimeTributario regimeTributario;

    public PessoaFisica(String nome,
                        String cpf,
                        String email,
                        String senha,
                        String telefone,
                        InscricaoContribuinte inscricaoEstadual,
                        RegimeTributario regimeTributario){
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.inscricaoEstadual = inscricaoEstadual;
        this.regimeTributario = regimeTributario;
        this.usuario = new Usuario(this.cpf, senha);
    }

    // Criar testes com base nesta classe, entendendo conceito de TDD.
    // Criar construtor de Pessoa Física completo, login e senha, com regras de obrigatoriedade,

//    public PessoaFisica(String id, Usuario usuario, Municipio municipio, String nome, String email, String cpf, String telefone, InscricaoContribuinte inscricaoEstadual, RegimeTributario regimeTributario) {
//        this.id = id;
//        this.usuario = usuario;
//        this.municipio = municipio;
//        this.nome = nome;
//        this.email = email;
//        this.cpf = cpf;
//        this.telefone = telefone;
//        this.inscricaoEstadual = inscricaoEstadual;
//        this.regimeTributario = regimeTributario;
//    }


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
