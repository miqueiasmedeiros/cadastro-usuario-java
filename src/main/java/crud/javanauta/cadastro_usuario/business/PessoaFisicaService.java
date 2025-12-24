package crud.javanauta.cadastro_usuario.business;

import crud.javanauta.cadastro_usuario.infrastructure.entitys.PessoaFisica;
import crud.javanauta.cadastro_usuario.infrastructure.repository.PessoaFisicaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PessoaFisicaService {

    private final PessoaFisicaRepository repository;

    public PessoaFisicaService(PessoaFisicaRepository repository){
        this.repository = repository;
    }

    public PessoaFisica salvarPessoaFisica(PessoaFisica pf){
        pf.setId(UUID.randomUUID().toString());
        repository.saveAndFlush(pf);
        return pf;
    }

}
