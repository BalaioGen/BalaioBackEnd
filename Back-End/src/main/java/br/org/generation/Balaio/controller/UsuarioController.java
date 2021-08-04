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

import br.org.generation.Balaio.repository.UsuarioRepository;
import br.org.generation.Balaio.model.UsuarioModel;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins="*", allowedHeaders="*")
public class UsuarioController {

    @Autowired
    private UsuarioRepository UsuarioRepository;

    @GetMapping("/{id}")
    private ResponseEntity<UsuarioModel> getById(@PathVariable long id) {
        return UsuarioRepository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    private ResponseEntity<List<UsuarioModel>> getAll() {
        return ResponseEntity.ok(UsuarioRepository.findAll());
    }

    @GetMapping("/Nome/{nome}")
    private ResponseEntity<List<UsuarioModel>> getByNome(@PathVariable String nome) {
        return ResponseEntity.ok(UsuarioRepository.findAllByNomeContainingIgnoreCase(nome));
    }

    //Cadastrar
    @PostMapping
    public ResponseEntity<UsuarioModel> post(@RequestBody UsuarioModel UsuarioModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioRepository.save(UsuarioModel));
    }
    //Alterar Postagem
    @PutMapping
    public ResponseEntity<UsuarioModel> put(@RequestBody UsuarioModel UsuarioModel) {
        return ResponseEntity.status(HttpStatus.OK).body(UsuarioRepository.save(UsuarioModel));
    }
    //Deletar Postagem
    @DeleteMapping("/{id}")
    public void getId(@PathVariable long id) {
        UsuarioRepository.deleteById(id);
    }

}
