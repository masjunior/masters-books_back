package com.example.masters_of_books.dominio;

import com.example.masters_of_books.pais.Pais;
import com.example.masters_of_books.utils.dominio.DominioNomeado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "estados")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id")),
        @AttributeOverride(name = "nome", column = @Column(name = "nome")),
})
public class Estado extends DominioNomeado {
    @Column(name = "sigla")
    private String sigla;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

}
