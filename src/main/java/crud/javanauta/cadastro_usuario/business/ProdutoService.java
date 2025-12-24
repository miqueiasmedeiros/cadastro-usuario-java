package crud.javanauta.cadastro_usuario.business;

import crud.javanauta.cadastro_usuario.infrastructure.entitys.Produto;
import crud.javanauta.cadastro_usuario.infrastructure.repository.ProdutosRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final ProdutosRepository repository;

    public ProdutoService(ProdutosRepository repository){

        this.repository = repository;
    }

    public Produto salvarProduto(Produto produto){

        repository.saveAndFlush(produto);
        return produto;
    }

    public Produto buscarProdutosPorId(Integer id){
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Produto não encontrado!")
        );
    }
    public void deletarProdutoPorId(Integer id){

        repository.deleteById(id);
    }
}
