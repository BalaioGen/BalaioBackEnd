package br.org.generation.Balaio.repository;

import br.org.generation.Balaio.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
    public List<ProdutoModel> findAllBynomeprodutoContainingIgnoreCase(String nomeproduto);
}
