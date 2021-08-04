package br.org.generation.Balaio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.Balaio.repository.CategoriaRepository;
import br.org.generation.Balaio.model.CategoriaModel;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins="*", allowedHeaders="*")

public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping("/{id}")
	private ResponseEntity<CategoriaModel> getById(@PathVariable long id) {
		return categoriaRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping
	private ResponseEntity<List<CategoriaModel>> getAll() {
		return ResponseEntity.ok(categoriaRepository.findAll());
	}
		
	@GetMapping("/descricao/{descricao}")
	private ResponseEntity<List<CategoriaModel>> getByDescricao(@PathVariable String descricao) {
		return ResponseEntity.ok(categoriaRepository.findAllByDescricaoContainingIgnoreCase(descricao));	
	}
	
	@GetMapping("/PalavraChave/{PalavraChave}")
	private ResponseEntity<List<CategoriaModel>> getByPalavraChave(@PathVariable String PalavraChave) {
		return ResponseEntity.ok(categoriaRepository.findAllByPalavraChaveContainingIgnoreCase(PalavraChave));	
	}
	
	//Cadastrar
	@PostMapping
 	public ResponseEntity<CategoriaModel> post(@RequestBody CategoriaModel categoriaModel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoriaModel));
	}
	//Alterar Postagem
	@PutMapping	
 	public ResponseEntity<CategoriaModel> put(@RequestBody CategoriaModel categoriaModel) {
		return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(categoriaModel));
	}
	//Deletar Postagem
	@DeleteMapping("/{id}")
	public void getId(@PathVariable long id) {
		categoriaRepository.deleteById(id);
	}
}