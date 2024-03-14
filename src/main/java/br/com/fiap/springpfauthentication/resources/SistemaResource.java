package br.com.fiap.springpfauthentication.resources;

import br.com.fiap.springpfauthentication.entity.Sistema;
import br.com.fiap.springpfauthentication.repository.SistemaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/sistema")
public class SistemaResource {

    @Autowired
    private SistemaRepository sistemaRepository;

    @GetMapping
    public List<Sistema> findAll() {
        return sistemaRepository.findAll();
    }


    @GetMapping(value = "/{id}")
    public Sistema findById(@PathVariable Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID não pode ser nulo");
        }
        return sistemaRepository.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Sistema save(@RequestBody Sistema sistema) {
        return sistemaRepository.save(sistema);
    }
}
