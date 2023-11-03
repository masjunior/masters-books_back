package com.example.masters_of_books.estado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
    // Você pode adicionar consultas personalizadas aqui, se necessário
}
