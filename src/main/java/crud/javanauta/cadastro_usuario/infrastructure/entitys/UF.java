package crud.javanauta.cadastro_usuario.infrastructure.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "uf")
public class UF {

    @Id
    @Column(name = "sigla", length = 2)
    private String sigla;
    private String nome;


}
