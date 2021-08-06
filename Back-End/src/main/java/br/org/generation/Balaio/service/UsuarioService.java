package br.org.generation.Balaio.service;

import br.org.generation.Balaio.model.UsuarioLogin;
import br.org.generation.Balaio.model.UsuarioModel;
import br.org.generation.Balaio.repository.UsuarioRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.nio.charset.Charset;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<UsuarioModel> cadastrarUsuario(UsuarioModel usuario) {
        if(usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já existe!", null);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String senhaEncoder = encoder.encode(usuario.getSenha());
        usuario.setSenha(senhaEncoder);

        return Optional.of(usuarioRepository.save(usuario));

    }
    public Optional<UsuarioModel> atualizarUsuario(UsuarioModel usuario){

        if(usuarioRepository.findById(usuario.getId()).isPresent()) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String senhaEncoder = encoder.encode(usuario.getSenha());
            usuario.setSenha(senhaEncoder);
            return Optional.of(usuarioRepository.save(usuario));
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND," User not Found!", null);


    }

    public Optional<UsuarioLogin> logarUsuario(Optional<UsuarioLogin> usuarioLogin) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Optional<UsuarioModel> usuario = usuarioRepository.findByUsuario(usuarioLogin.get().getUsuario());
        if (usuario.isPresent()) {
            if (encoder.matches(usuarioLogin.get().getSenha(), usuario.get().getSenha())) {
                String auth = usuarioLogin.get().getUsuario() + ":" + usuarioLogin.get().getSenha();
                byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String(encodedAuth);
                usuarioLogin.get().setId(usuario.get().getId());
                usuarioLogin.get().setNome(usuario.get().getNome());
                usuarioLogin.get().setSenha(usuario.get().getSenha());
                usuarioLogin.get().setToken(authHeader);

                return usuarioLogin;
            }

        }
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Usuário ou senha inválidos!", null);

        }

}
