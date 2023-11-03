package com.example.masters_of_books.estado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    private final EstadoRepository repository;

    @Autowired
    public EstadoService(EstadoRepository repository) {
        this.repository = repository;
    }

    public List<Estado> listar() {
        return repository.findAll();
    }

    public Estado buscarPorId(Long id) {
        Optional<Estado> Estado = repository.findById(id);
        return Estado.orElse(null);
    }

    public void salvar(Estado estado) {
        repository.save(estado);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}

