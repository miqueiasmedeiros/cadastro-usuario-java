package crud.javanauta.cadastro_usuario.infrastructure.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class InscricaoContribuinte {


    @Column(unique = true)
    private String codigo;
}
