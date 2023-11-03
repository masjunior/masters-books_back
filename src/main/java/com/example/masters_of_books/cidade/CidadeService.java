package com.example.masters_of_books.cidade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    private final CidadeRepository repository;

    @Autowired
    public CidadeService(CidadeRepository repository) {
        this.repository = repository;
    }

    public List<Cidade> listar() {
        return repository.findAll();
    }

    public Cidade buscarPorId(Long id) {
        Optional<Cidade> cidade = repository.findById(id);
        return cidade.orElse(null);
    }

    public void salvar(Cidade Cidade) {
        repository.save(Cidade);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}

