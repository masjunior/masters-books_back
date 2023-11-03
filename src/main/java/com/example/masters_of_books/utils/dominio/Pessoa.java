package com.example.masters_of_books.utils.dominio;

import com.example.masters_of_books.endereco.Endereco;
import com.example.masters_of_books.genero.Genero;
import com.example.masters_of_books.dominio.Telefone;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({
//        @AttributeOverride(name = "id", column = @Column(name = "id")),
        @AttributeOverride(name = "nome", column = @Column(name = "nome")),
})
@Entity
public class Pessoa extends DominioNomeado {
    @OneToOne
    private Genero genero;
    @Column(name = "data_nascimento")
    private Date dataNascimento;
    @Column(name = "cpf")
    private String cpf;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa", orphanRemoval = true)
    private List<Telefone> telefones;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa", orphanRemoval = true)
    private List<Endereco> enderecos;
}
