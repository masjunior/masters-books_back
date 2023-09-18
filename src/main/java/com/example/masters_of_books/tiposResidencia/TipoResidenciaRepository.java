package com.example.masters_of_books.tiposResidencia;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoResidenciaRepository extends JpaRepository<TipoResidencia, Long> {
    // Você pode adicionar consultas personalizadas aqui, se necessário
}
