package com.example.masters_of_books.dominio;


import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "enderecos")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo_residencia")
    @JdbcTypeCode(SqlTypes.JSON)
    private TipoResidencia tipoResidencia;
    @Column(name = "tipo_logradouro")
    @JdbcTypeCode(SqlTypes.JSON)
    private TipoLogradouro tipoLogradouro;
    @Column(name = "logradouro")
    private String logradouro;
    @Column(name = "numero")
    private String numero;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cep")
    private String cep;
    @ManyToOne
    @JoinColumn(name="cidade_id")
    private Cidade cidade;
//    @Column(name = "apelido")
//    private String apelido;
//
//    @PrimaryKeyJoinColumn
//    private Cliente cliente;
//
//
//    @PrimaryKeyJoinColumn
//    private Pedido pedido;

}
