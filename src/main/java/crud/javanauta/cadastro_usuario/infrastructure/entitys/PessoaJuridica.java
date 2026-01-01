package crud.javanauta.cadastro_usuario.infrastructure.entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PessoaJuridica /*implements Conta*/{



//    PessoaJuridica pj = new PessoaJuridica();
//
//    String email = pj.getEmail();

    @Id
    private String id;

    @OneToOne
    private Usuario usuario;

    @ManyToOne
    private Municipio municipio;

    @Column(nullable = false)
    private String razaoSocial;

    private String nomeFantasia;

    @Column(nullable = false, unique = true)
    private String cnpj;

    @Column(nullable = false)
    @Email(message = "Email inválido!")
    private String email;

     // Se habilitado NFSe | Transformar em Objeto
    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "codigo", column = @Column(name = "inscricao_municipal"))

    )
    private InscricaoContribuinte inscricaoMunicipal;

    // Se habilitado NFe ou NFCe | Transformar em Objeto
    // Quando não for usado para calcular usar String ao invés de Integer
    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "codigo", column = @Column(name = "inscricao_estadual"))
    )

    private InscricaoContribuinte inscricaoEstadual;


    @Column(nullable = false)
    private String regimeTributario;

//    private String conta;
//
//    private String agencia;

    // Aqui pega os beneficios da interface Conta por default
//    String beneficios = pj.getBeneficios();

}
