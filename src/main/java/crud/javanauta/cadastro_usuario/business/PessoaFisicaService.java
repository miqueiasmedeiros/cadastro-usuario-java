package crud.javanauta.cadastro_usuario.business;

import crud.javanauta.cadastro_usuario.infrastructure.entitys.PessoaFisica;
import crud.javanauta.cadastro_usuario.infrastructure.entitys.PessoaJuridica;
import crud.javanauta.cadastro_usuario.infrastructure.exceptions.CpfJaCadastradoException;
import crud.javanauta.cadastro_usuario.infrastructure.exceptions.PessoaFisicaExceptions;
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
        if(repository.existsByCpf(pf.getCpf())){
            throw new CpfJaCadastradoException("CPF já cadastrado no sistema");
        }
        pf.setId(UUID.randomUUID().toString());
        repository.saveAndFlush(pf);
        return pf;
    }

    public PessoaFisica buscarPessoaFisicaPorEmail(String email){
        return repository.findByEmail(email).orElseThrow(
                ()-> new PessoaFisicaExceptions("Email não encontrado"));
    }

    public PessoaFisica buscarPessoaFisicaPorId(String id){
        return repository.findById(id).orElseThrow(() -> new PessoaFisicaExceptions("Cadastro não encontrado!"));
    }

    public void deletarPessoaFisicaPorId(String id){
        if (!repository.existsById(id)){
            throw new PessoaFisicaExceptions("Cadastro Inexistente!");
        }
        repository.deleteById(id);
    }

}
