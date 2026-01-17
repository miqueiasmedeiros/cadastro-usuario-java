package crud.javanauta.cadastro_usuario.controller.dto;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PessoaFisicaDTO {

        private String nome;
        private String cpf;
        @Email(message = "Email anotado inválido!")
        private String email;
        private String senha;
        private String telefone;
        private String inscricaoEstadual;
        private String regimeTributario;
        private String municipio;

    }
