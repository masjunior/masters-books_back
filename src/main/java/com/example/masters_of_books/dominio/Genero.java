package com.example.masters_of_books.dominio;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "genero")
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DescricaoEnum descricao;

    @Getter
    public enum DescricaoEnum {
        MASCULINO,
        FEMININO,
        OUTRO;
    }
}