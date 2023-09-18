package com.example.masters_of_books.cliente;

import com.example.masters_of_books.utils.dominio.Dominio;
import com.example.masters_of_books.utils.dominio.Pessoa;
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
@Table(name = "cliente")
public class Cliente extends Dominio {

    @Column(name = "email")
    private String email;
    @Column(name = "senha")
    private String senha;

    @OneToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    private Pessoa pessoa;

}

