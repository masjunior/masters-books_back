package com.example.masters_of_books.pais;

import com.example.masters_of_books.utils.dominio.DominioNomeado;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
@Table(name = "pais")
public class Pais extends DominioNomeado {

}
