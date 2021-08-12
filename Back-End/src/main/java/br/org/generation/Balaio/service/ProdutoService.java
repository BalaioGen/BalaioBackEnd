package br.org.generation.Balaio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.org.generation.Balaio.model.ProdutoModel;
import br.org.generation.Balaio.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public ProdutoModel favoritar(Long id) {
		ProdutoModel produto = buscarProdutoPeloId(id);
		produto.setFavoritos(produto.getFavoritos()+1);
		return produtoRepository.save(produto);
	}
	
	public ProdutoModel desfavoritar (Long id) {
		ProdutoModel produto = buscarProdutoPeloId(id);
		
		if (produto.getFavoritos() > 0) {
			produto.setFavoritos(produto.getFavoritos()-1);
		} else {
			produto.setFavoritos(0);
		}
		return produtoRepository.save(produto);
	}
	
	private ProdutoModel buscarProdutoPeloId (Long id) {
		ProdutoModel produtoSalvo = produtoRepository.findById(id).orElse(null);
		
		if (produtoSalvo == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado!", null);
		}
		
		return produtoSalvo;
	}

}
