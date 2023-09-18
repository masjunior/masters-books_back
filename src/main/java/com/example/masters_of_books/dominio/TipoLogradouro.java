package com.example.masters_of_books.dominio;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "tipos_logradouro")
public class TipoLogradouro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DescricaoEnum descricao;

    @Getter
    public enum DescricaoEnum {
        RUA,
        AVENIDA,
        TRAVESSA,
        OUTRO
    }
}
