package com.example.masters_of_books.utils.service;

import com.example.masters_of_books.utils.dominio.Dominio;
import com.example.masters_of_books.utils.repository.DominioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DominioService {

    private final DominioRepository dominioRepository;

    @Autowired
    public DominioService(DominioRepository dominioRepository) {
        this.dominioRepository = dominioRepository;
    }

    public List<Dominio> listar() {
        return dominioRepository.findAll();
    }

    public Dominio buscarPorId(Long id) {
        Optional<Dominio> dominio = dominioRepository.findById(id);
        return dominio.orElse(null);
    }

    public void salvar(Dominio dominio) {
        dominioRepository.save(dominio);
    }

    public void excluir(Long id) {
        dominioRepository.deleteById(id);
    }
}

