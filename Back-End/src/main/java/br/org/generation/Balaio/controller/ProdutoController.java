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

import br.org.generation.Balaio.repository.ProdutoRepository;
import br.org.generation.Balaio.service.ProdutoService;
import br.org.generation.Balaio.model.ProdutoModel;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins="*", allowedHeaders="*")

public class ProdutoController {

    @Autowired
    private ProdutoRepository ProdutoRepository;

    @GetMapping("/{id}")
    private ResponseEntity<ProdutoModel> getById(@PathVariable long id) {
        return ProdutoRepository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    private ResponseEntity<List<ProdutoModel>> getAll() {
        return ResponseEntity.ok(ProdutoRepository.findAll());
    }

    @GetMapping("/Nome/{nomeproduto}")
    private ResponseEntity<List<ProdutoModel>> getByPalavraChave(@PathVariable String nomeproduto) {
        return ResponseEntity.ok(ProdutoRepository.findAllBynomeprodutoContainingIgnoreCase(nomeproduto));
    }

    //Cadastrar
    @PostMapping
    public ResponseEntity<ProdutoModel> post(@RequestBody ProdutoModel ProdutoModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ProdutoRepository.save(ProdutoModel));
    }
    //Alterar Postagem
    @PutMapping
    public ResponseEntity<ProdutoModel> put(@RequestBody ProdutoModel ProdutoModel) {
        return ResponseEntity.status(HttpStatus.OK).body(ProdutoRepository.save(ProdutoModel));
    }
    //Deletar Postagem
    @DeleteMapping("/{id}")
    public void getId(@PathVariable long id) {
        ProdutoRepository.deleteById(id);
    }
    
    //Favoritar produtos
    @PutMapping("/favoritar/{id}")
    public ResponseEntity<ProdutoModel> putFavoritarProdutoId (@PathVariable Long id){
    	return ResponseEntity.status(HttpStatus.OK).body(ProdutoService.favoritar(id));
    }
    
    @PutMapping("/desfavoritar/{id}")
    public ResponseEntity<ProdutoModel> putDesfavoritarProdutoId (@PathVariable Long id){
    	return ResponseEntity.status(HttpStatus.OK).body(ProdutoService.desfavoritar(id));
    }
}










