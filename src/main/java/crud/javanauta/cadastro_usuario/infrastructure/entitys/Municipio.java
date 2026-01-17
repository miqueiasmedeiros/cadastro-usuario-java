package crud.javanauta.cadastro_usuario.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "municipio")
public class Municipio{

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "uf_sigla",
            referencedColumnName = "sigla",
            nullable = false)
    private UF uf;

    @Id
    @Column(name = "codigo")
    private String codigo;
    @Column(nullable = false)
    private String nome;
}
