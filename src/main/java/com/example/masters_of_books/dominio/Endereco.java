package com.example.masters_of_books.dominio;


import com.example.masters_of_books.cidade.Cidade;
import com.example.masters_of_books.tiposResidencia.TipoResidencia;
import com.example.masters_of_books.utils.dominio.Dominio;
import com.example.masters_of_books.utils.dominio.Pessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "enderecos")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id")),
})
public class Endereco extends Dominio {

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
    @JoinColumn(name = "cidade_id", referencedColumnName = "id")
    private Cidade cidade;
    @Column(name = "apelido")
    private String apelido;

    @Column(name = "principal")
    private Boolean principal;

    @OneToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id", unique = false)
    private Pessoa pessoa;


    @OneToOne
    @JoinColumn(name = "pedido_id", referencedColumnName = "id")
    private Pedido pedido;

}
