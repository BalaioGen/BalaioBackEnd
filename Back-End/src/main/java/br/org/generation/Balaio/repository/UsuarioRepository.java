package br.org.generation.Balaio.repository;

import br.org.generation.Balaio.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    public List<UsuarioModel> findAllByNomeContainingIgnoreCase(String nome);
   
    public Optional<UsuarioModel> findByUsuario(String usuario);
   
    public Optional<UsuarioModel> findByNome(String nome); 
    
    public Optional<UsuarioModel> findByid(Long id);
    
}
