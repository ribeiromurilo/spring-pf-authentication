package br.com.fiap.springpfauthentication.resources;

import br.com.fiap.springpfauthentication.entity.Usuario;
import br.com.fiap.springpfauthentication.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioResource {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }


    @GetMapping(value = "/{id}")
    public Usuario findById(@PathVariable Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID não pode ser nulo");
        }
        return usuarioRepository.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Usuario save(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}