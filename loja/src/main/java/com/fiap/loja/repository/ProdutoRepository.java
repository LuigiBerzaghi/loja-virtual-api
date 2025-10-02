package com.fiap.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fiap.loja.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
