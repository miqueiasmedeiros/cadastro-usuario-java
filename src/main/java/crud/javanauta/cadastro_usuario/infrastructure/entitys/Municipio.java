package crud.javanauta.cadastro_usuario.infrastructure.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Municipio{

    @ManyToOne
    private UF uf;
    @Id()
    @Column(name = "id")
    private String codigo;
    private String nome;
}
