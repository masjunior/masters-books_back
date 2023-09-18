package com.example.masters_of_books.pais;

import com.example.masters_of_books.dominio.Pais;
import com.example.masters_of_books.pais.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisService {

    private final PaisRepository paisRepository;

    @Autowired
    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    public List<Pais> listar() {
        return paisRepository.findAll();
    }

    public Pais buscarPorId(Long id) {
        Optional<Pais> pais = paisRepository.findById(id);
        return pais.orElse(null);
    }

    public void salvar(Pais pais) {
        paisRepository.save(pais);
    }

    public void excluir(Long id) {
        paisRepository.deleteById(id);
    }
}

