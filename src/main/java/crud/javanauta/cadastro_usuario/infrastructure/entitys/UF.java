package crud.javanauta.cadastro_usuario.infrastructure.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UF {

    @Id
    @Column(name = "id")
    private String sigla;
    private String nome;


}
