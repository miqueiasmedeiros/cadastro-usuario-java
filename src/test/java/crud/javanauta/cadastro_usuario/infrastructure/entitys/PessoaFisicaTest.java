package crud.javanauta.cadastro_usuario.infrastructure.entitys;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class PessoaFisicaTest{

    @Test
    public void criarPessoaFisicaVazia(){
        PessoaFisica pf = new PessoaFisica();
        assertNotNull(pf);
    }
//    @Test
//    public void criarPessoaValidandoDadosObrigatorios() {
//        InscricaoContribuinte inscricao = new InscricaoContribuinte();
//        inscricao.setCodigo("ISENTO");
//
//        PessoaFisica pf = new PessoaFisica("Micke",
//                "1234567891",
//                "teste@teste.com",
//                "123",
//                "987654321",
//                inscricao,
//                RegimeTributario.SIMPLES_NACIONAL_MEI);
//        assertNotNull(pf.getNome());
//        assertNotNull(pf.getCpf());
//        assertNotNull(pf.getEmail());
//        assertNotNull(pf.getTelefone());
//    }

    // TDD (Test Driving Development) - Desenvolvimento Orientado à Teste
//    @Test
//    public void verificaIgualdade() {
//        InscricaoContribuinte inscricao = new InscricaoContribuinte();
//        inscricao.setCodigo("ISENTO");
//
//        PessoaFisica pf = new PessoaFisica("Micke",
//                "1234567891",
//                "teste@teste.com",
//                "1231231",
//                "123456789",
//                inscricao,
//                RegimeTributario.SIMPLES_NACIONAL_MEI);
//        assertEquals("Micke", pf.getNome());
//
//
//    }

}
