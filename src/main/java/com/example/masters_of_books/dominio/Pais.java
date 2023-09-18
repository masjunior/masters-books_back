package com.example.masters_of_books.dominio;

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
//@NoArgsConstructor
@Table(name = "pais")
public class Pais extends DominioNomeado {

}
