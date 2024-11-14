package io.github.com.devcarlos.produtosapi.controller;

import io.github.com.devcarlos.produtosapi.model.Produto;
import io.github.com.devcarlos.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

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

}
