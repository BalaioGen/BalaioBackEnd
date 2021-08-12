package br.org.generation.Balaio.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.org.generation.Balaio.model.ProdutoModel;

@Repository
@Transactional(readOnly = true)
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
	
    public List<ProdutoModel> findAllBynomeprodutoContainingIgnoreCase(String nomeproduto);
    
    @Query(value = "select count(categoria_id) from tb_produto where categoria_id = :id", nativeQuery = true)
    public int countProdutos(@Param("id") long id);
}
