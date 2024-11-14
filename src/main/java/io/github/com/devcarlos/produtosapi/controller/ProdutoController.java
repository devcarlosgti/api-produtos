package io.github.com.devcarlos.produtosapi.controller;

import io.github.com.devcarlos.produtosapi.model.Produto;
import io.github.com.devcarlos.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    //Salvar produtos
    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        System.out.println("Produto salvo: " + produto);

        //gerar um id
        var id = UUID.randomUUID().toString();
        produto.setId(id);

        //salvo
        produtoRepository.save(produto);
        return produto;
    }

    //buscar por id
    @GetMapping("{id}")
    public Produto obterPorId(@PathVariable("id") String id){
//        Optional<Produto> produto  = produtoRepository.findById(id);
//        return produto.isPresent() ? produto.get() : null;

        //simplificar
        return produtoRepository.findById(id).orElse(null);
    }

    //deletar
    @DeleteMapping("{id}")
    public void deletar(@PathVariable("id") String id){
        produtoRepository.deleteById(id);
    }

}
