package com.example.masters_of_books.dominio;

import com.example.masters_of_books.utils.dominio.Dominio;
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
@Table(name="cidades")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id")),
})
public class Cidade extends DominioNomeado {

    @ManyToOne
    @JoinColumn(name="estado_id", referencedColumnName = "id")
    private Estado estado;

}
