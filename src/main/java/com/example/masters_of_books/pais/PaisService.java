package com.example.masters_of_books.pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisService {

    private final PaisRepository repository;

    @Autowired
    public PaisService(PaisRepository repository) {
        this.repository = repository;
    }

    public List<Pais> listar() {
        return repository.findAll();
    }

    public Pais buscarPorId(Long id) {
        Optional<Pais> pais = repository.findById(id);
        return pais.orElse(null);
    }

    public void salvar(Pais pais) {
        repository.save(pais);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}

