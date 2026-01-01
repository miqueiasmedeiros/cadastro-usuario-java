package crud.javanauta.cadastro_usuario.business;

import crud.javanauta.cadastro_usuario.controller.dto.PessoaFisicaDTO;
import crud.javanauta.cadastro_usuario.infrastructure.entitys.Municipio;
import crud.javanauta.cadastro_usuario.infrastructure.entitys.PessoaFisica;
import crud.javanauta.cadastro_usuario.infrastructure.exceptions.BadRequestExceptions;
import crud.javanauta.cadastro_usuario.infrastructure.exceptions.GlobalExceptions;
import crud.javanauta.cadastro_usuario.infrastructure.repository.MunicipioRepository;
import crud.javanauta.cadastro_usuario.infrastructure.repository.PessoaFisicaRepository;
import crud.javanauta.cadastro_usuario.util.ValidaCPF;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PessoaFisicaService {

    private final PessoaFisicaRepository pessoaFisicaRepository;

    private final MunicipioRepository municipioRepository;

//    public PessoaFisicaService(PessoaFisicaRepository pessoaFisicaRepository){
//        this.pessoaFisicaRepository = pessoaFisicaRepository;
//    } @RequiredArgsConstructor = ao construtor.

    public PessoaFisica salvarPessoaFisica(PessoaFisicaDTO pf){
        if(pessoaFisicaRepository.existsByCpf(pf.getCpf())){
            throw new BadRequestExceptions("CPF já cadastrado no sistema");
            // Criar uma Exception genérica para todas as validações

        }

        if (!ValidaCPF.isCPF(pf.getCpf())){
            throw new BadRequestExceptions ("CPF: " + pf.getCpf() + " inválido.");
        }

        if(pf.getInscricaoEstadual() != null &&
                pessoaFisicaRepository.existsByInscricaoEstadual_Codigo(pf.getInscricaoEstadual())){
            throw new GlobalExceptions("Inscricão estadual já cadastrada no sistema");
        }

        Optional<Municipio> municipio = municipioRepository
                .findById(pf.getMunicipio());
        if(municipio.isEmpty()){
            throw new GlobalExceptions("Município não encontrado");
        }
        PessoaFisica pessoaFisica = new PessoaFisica(
                pf.getNome(),
                pf.getCpf(),
                pf.getEmail(),
                pf.getSenha(),
                pf.getTelefone(),
                pf.getInscricaoEstadual(),
                pf.getRegimeTributario(),
                municipio.get()
        );

        return pessoaFisicaRepository.saveAndFlush(pessoaFisica);

    }

    public PessoaFisica buscarPessoaFisicaPorEmail(String email){
        return pessoaFisicaRepository.findByEmail(email).orElseThrow(
                ()-> new GlobalExceptions("Email não encontrado."));
    }

    public PessoaFisica buscarPessoaFisicaPorId(String id){
        return pessoaFisicaRepository.findById(id).orElseThrow(() -> new GlobalExceptions("Id não encontrado!"));
    }

    public void deletarPessoaFisicaPorId(String id){
        if (!pessoaFisicaRepository.existsById(id)){
            throw new GlobalExceptions("Cadastro Inexistente!");
        }
        pessoaFisicaRepository.deleteById(id);
    }

}
