package com.example.masters_of_books.cidade;

import com.example.masters_of_books.estado.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    // Você pode adicionar consultas personalizadas aqui, se necessário
}


