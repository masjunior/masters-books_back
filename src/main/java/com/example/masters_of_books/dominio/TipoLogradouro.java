package com.example.masters_of_books.dominio;

import com.example.masters_of_books.utils.dominio.Dominio;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "tipos_logradouro")
public class TipoLogradouro extends Dominio {

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
