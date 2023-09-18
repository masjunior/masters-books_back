package com.example.masters_of_books.tiposResidencia;

import com.example.masters_of_books.utils.dominio.Dominio;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "tipos_residencia")
public class TipoResidencia extends Dominio {

    @Enumerated(EnumType.STRING)
    private DescricaoEnum descricao;

    @Getter
    public enum DescricaoEnum {
        CASA,
        APARTAMENTO,
        OUTRO
    }
}