package com.example.masters_of_books.genero;

import com.example.masters_of_books.utils.dominio.Dominio;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "genero")
public class Genero extends Dominio {

    @Enumerated(EnumType.STRING)
    private DescricaoEnum descricao;

    @Getter
    public enum DescricaoEnum {
        MASCULINO,
        FEMININO,
        OUTRO
    }
}