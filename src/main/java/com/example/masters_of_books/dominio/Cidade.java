package com.example.masters_of_books.dominio;

import com.example.masters_of_books.utils.dominio.DominioNomeado;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cidades")
public class Cidade extends DominioNomeado {

    @ManyToOne
    @JoinColumn(name = "estado_id", referencedColumnName = "id")
    private Estado estado;

}
