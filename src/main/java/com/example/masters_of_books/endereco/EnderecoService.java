package com.example.masters_of_books.endereco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    private final EnderecoRepository repository;

    @Autowired
    public EnderecoService(EnderecoRepository repository) {
        this.repository = repository;
    }

    public List<Endereco> listar() {
        return repository.findAll();
    }

    public Endereco buscarPorId(Long id) {
        Optional<Endereco> Endereco = repository.findById(id);
        return Endereco.orElse(null);
    }

    public void salvar(Endereco Endereco) {
        repository.save(Endereco);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}

