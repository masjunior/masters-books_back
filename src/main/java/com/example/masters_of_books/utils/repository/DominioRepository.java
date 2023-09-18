package com.example.masters_of_books.utils.repository;


import com.example.masters_of_books.dominio.Pais;
import com.example.masters_of_books.utils.dominio.Dominio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DominioRepository extends JpaRepository<Dominio, Long> {
    // Você pode adicionar consultas personalizadas aqui, se necessário
}
