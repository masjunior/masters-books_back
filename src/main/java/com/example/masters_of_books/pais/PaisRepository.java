package com.example.masters_of_books.pais;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
    // Você pode adicionar consultas personalizadas aqui, se necessário
}
