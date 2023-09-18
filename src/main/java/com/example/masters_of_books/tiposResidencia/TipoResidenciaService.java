package com.example.masters_of_books.tiposResidencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoResidenciaService {

    private final TipoResidenciaRepository tipoResidenciaRepository;

    @Autowired
    public TipoResidenciaService(TipoResidenciaRepository tipoResidenciaRepository) {
        this.tipoResidenciaRepository = tipoResidenciaRepository;
    }

    public List<TipoResidencia> listar() {
        return tipoResidenciaRepository.findAll();
    }

    public TipoResidencia buscarPorId(Long id) {
        Optional<TipoResidencia> tipoResidencia = tipoResidenciaRepository.findById(id);
        return tipoResidencia.orElse(null);
    }

    public void salvar(TipoResidencia tipoResidencia) {
        tipoResidenciaRepository.save(tipoResidencia);
    }

    public void excluir(Long id) {
        tipoResidenciaRepository.deleteById(id);
    }
}

