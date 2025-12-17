package crud.javanauta.cadastro_usuario.infrastructure.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RegimeTributario {

    SIMPLES_NACIONAL_MEI(10),
    REGIME_NORMAL(11),
    LUCRO_REAL(12);

    private final int codigo;
}
