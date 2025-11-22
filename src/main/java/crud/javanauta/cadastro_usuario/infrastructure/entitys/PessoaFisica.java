package crud.javanauta.cadastro_usuario.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PessoaFisica extends Usuario implements Conta{

    private String cpf;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

//    @Embedded
//    private Usuario usuario;

//    PessoaFisica pf = new PessoaFisica();
//    String email = pf.getUsuario().getEmail();

    private String conta;

    private String agencia;

    @Override
    // Aqui seta o benefício que eu atribuir.......
    public String getBeneficios(){
        return "Eu sou outra mensangem!";
    }

}
