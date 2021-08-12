package br.org.generation.Balaio.repository;

import java.util.List;
import br.org.generation.Balaio.model.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long>{
		
	public List<CategoriaModel> findAllByDescricaoContainingIgnoreCase(String Categoria);
	public List<CategoriaModel> findAllByPalavraChaveContainingIgnoreCase(String PalavraChave);
	
	}
