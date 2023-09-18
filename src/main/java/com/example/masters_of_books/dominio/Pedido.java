package com.example.masters_of_books.dominio;

import com.example.masters_of_books.cliente.Cliente;
import com.example.masters_of_books.utils.dominio.Dominio;
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
@Table(name = "pedidos")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id")),
})
public class Pedido extends Dominio {

    @Column(name = "numero")
    private String numero;

    @OneToOne(optional = false)
    @JoinColumn(name = "endereco_id", nullable = false, referencedColumnName = "id")
    private Endereco endereco;

    @OneToOne(optional = false)
    @JoinColumn(name = "cliente_id", nullable = false, referencedColumnName = "id")
    private Cliente cliente;

//    @OneToMany
//    private List<Item> itens;
}