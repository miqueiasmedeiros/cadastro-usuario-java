package crud.javanauta.cadastro_usuario.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Municipio{

    @ManyToOne
    @JoinColumn(name = "uf_id", nullable = false)
    private UF uf;
    @Id()
    @Column(name = "id")
    private String codigo;
    private String nome;
}
