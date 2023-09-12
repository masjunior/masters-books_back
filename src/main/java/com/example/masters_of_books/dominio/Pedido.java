//package com.example.masters_of_books.dominio;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToOne;
//import jakarta.persistence.PrimaryKeyJoinColumn;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Table(name = "pedidos")
//public class Pedido {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @Column(name = "numero")
//    private String numero;
//
//    @OneToOne(optional=false)
//    @JoinColumn( name="ID", nullable=false)
////    @Column(name = "endereco_id", nullable = true)
//    @PrimaryKeyJoinColumn
//    private Endereco endereco;
//}