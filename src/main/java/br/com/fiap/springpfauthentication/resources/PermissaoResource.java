package br.com.fiap.springpfauthentication.resources;

import br.com.fiap.springpfauthentication.entity.Permissao;
import br.com.fiap.springpfauthentication.repository.PermissaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/permissao")
public class PermissaoResource {

    @Autowired
    private PermissaoRepository permissaoRepository;

    @GetMapping
    public List<Permissao> findAll() {
        return permissaoRepository.findAll();
    }


    @GetMapping(value = "/{id}")
    public Permissao findById(@PathVariable Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID não pode ser nulo");
        }
        return permissaoRepository.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Permissao save(@RequestBody Permissao permissao) {
        return permissaoRepository.save(permissao);
    }
}