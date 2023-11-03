package com.example.masters_of_books.estado;

import com.example.masters_of_books.pais.Pais;
import com.example.masters_of_books.utils.dominio.DominioNomeado;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "estados")
public class Estado extends DominioNomeado {

    @Column(name = "sigla")
    private String sigla;

    @OneToOne
    @JoinColumn(name = "pais_id", referencedColumnName = "id")
    private Pais pais;

    public Estado() {

    }
}
