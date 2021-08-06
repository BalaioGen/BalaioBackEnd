package br.org.generation.Balaio.seguranca;


import br.org.generation.Balaio.model.UsuarioModel;
import br.org.generation.Balaio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UsuarioModel> usuario = userRepository.findByUsuario(username);
        usuario.orElseThrow(() -> new UsernameNotFoundException(username + " not found."));

        return usuario.map(UserDetailsImpl::new).get();

    }
}
