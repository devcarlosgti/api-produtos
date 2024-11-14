package io.github.com.devcarlos.produtosapi.repository;

import io.github.com.devcarlos.produtosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
}
