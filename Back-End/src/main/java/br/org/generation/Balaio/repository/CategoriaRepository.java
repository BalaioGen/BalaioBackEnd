package br.org.generation.balaio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.balaio.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
		
	public List<Categoria> findAllByDescricaoContainingIgnoreCase(String Categoria);
	
	public List<Categoria> findAllByPalavraChaveContainingIgnoreCase(String PalavraChave);
	
	}
