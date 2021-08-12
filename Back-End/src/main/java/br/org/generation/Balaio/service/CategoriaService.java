package br.org.generation.Balaio.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.generation.Balaio.model.CategoriaModel;
import br.org.generation.Balaio.repository.CategoriaRepository;
import br.org.generation.Balaio.repository.ProdutoRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<CategoriaModel> trendTopics(){
		
		List<CategoriaModel> categorias = categoriaRepository.findAll();
		
		for (CategoriaModel categoria : categorias) {
			categoria.setQtdCategoria(produtoRepository.countProdutos(categoria.getId()));
		}
		
		Collections.sort(categorias, Collections.reverseOrder(Comparator.comparing(CategoriaModel::getQtdCategoria)));
		return categorias;
	}

}














