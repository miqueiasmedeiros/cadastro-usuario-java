package crud.javanauta.cadastro_usuario.infrastructure.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PessoaJuridica extends Usuario implements Conta{

    private String cnpj;

//    PessoaJuridica pj = new PessoaJuridica();
//
//    String email = pj.getEmail();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String conta;

    private String agencia;

    // Aqui pega os beneficios da interface Conta por default
//    String beneficios = pj.getBeneficios();




}
