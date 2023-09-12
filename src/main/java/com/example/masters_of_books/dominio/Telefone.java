package com.example.masters_of_books.dominio;

import com.example.masters_of_books.utils.dominio.Dominio;
import com.example.masters_of_books.utils.dominio.Pessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "telefones")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id")),
})
public class Telefone extends Dominio {

	@Column(name = "tipo")
    private String tipo;
	@Column(name = "ddd")
    private String ddd;
	@Column(name = "numero")
    private String numero;

	@ManyToOne
	@JoinColumn(name="pessoa_id", nullable=false, referencedColumnName = "id")
    private Pessoa pessoa;
}
