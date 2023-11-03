package com.example.masters_of_books.genero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroService {

    private final GeneroRepository repository;

    @Autowired
    public GeneroService(GeneroRepository repository) {
        this.repository = repository;
    }

    public List<Genero> listar() {
        return repository.findAll();
    }

    public Genero buscarPorId(Long id) {
        Optional<Genero> entidade = repository.findById(id);
        return entidade.orElse(null);
    }

    public void salvar(Genero entidade) {
        repository.save(entidade);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}

