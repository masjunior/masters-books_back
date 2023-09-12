package com.example.masters_of_books.repository;

import com.example.masters_of_books.dominio.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Você pode adicionar consultas personalizadas aqui, se necessário
}
