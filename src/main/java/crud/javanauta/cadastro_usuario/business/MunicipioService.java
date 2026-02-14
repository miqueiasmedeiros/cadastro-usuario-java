package crud.javanauta.cadastro_usuario.business;

import crud.javanauta.cadastro_usuario.infrastructure.entitys.Municipio;
import crud.javanauta.cadastro_usuario.infrastructure.repository.MunicipioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MunicipioService {
    private final MunicipioRepository municipioRepository;

    public List<Municipio> listarMunicipios(){
        return municipioRepository.findAll();
    }
}
