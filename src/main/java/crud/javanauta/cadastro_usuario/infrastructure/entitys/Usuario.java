package crud.javanauta.cadastro_usuario.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor // Gera um construtor completo com todos os atributos
@NoArgsConstructor // Construtor sem argumentos
@Builder
@Table(name = "usuario")
//@Embeddable
@Entity // Jakarta a partir do java 17
public class Usuario {
    
    @Id
    private String id;

    @Column(unique = true, nullable = false)
   private String login;

    @Column(nullable = false)
    private String senha;

    public Usuario(String login, String senha){

        this.login = login;
        this.senha = senha;
    }

}
