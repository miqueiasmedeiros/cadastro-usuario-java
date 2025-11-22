package crud.javanauta.cadastro_usuario.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor // Gera um construtor completo com todos os atributos
@NoArgsConstructor // Construtor sem argumentos
@Builder
//@Embeddable
//@Entity // Jakarta a partir do java 17
public class Usuario {
    
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;
    
    @Column(name = "email", unique = true)
    private String email;
    
    @Column(name = "name")
    private String nome;

    @Column(unique = true)
   private String login;


    private String senha;


}
