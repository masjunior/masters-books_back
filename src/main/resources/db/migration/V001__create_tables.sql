    alter table if exists cidades
       drop constraint if exists FKdt0b3ronwpi1upsrhaeq6r69n;
    alter table if exists cliente
       drop constraint if exists FKje7d3c1jdkexkpnkmx3894wfi;
    alter table if exists enderecos
       drop constraint if exists FKi7v6nvtiwatf10fe6c8n7qbde;
    alter table if exists enderecos
       drop constraint if exists FKc6la0cgenglfgria2ictrp5gg;
    alter table if exists enderecos
       drop constraint if exists FK2cydyr5xb7otrl7go5erq7e10;
    alter table if exists estados
       drop constraint if exists FKrm78dlpkss2a2viv4ejjgviai;
    alter table if exists pedidos
       drop constraint if exists FK6wgk5emlhdcthucnnmi4dpl33;
    alter table if exists pedidos
       drop constraint if exists FKekuochlfkprh1dyhpi3nanalj;
    alter table if exists pessoa
       drop constraint if exists FKk85t81asvo1ahgnbn452sbox3;
    alter table if exists telefones
       drop constraint if exists FKpslyamytot17rnmig6ghq4x0l;
    drop table if exists cidades cascade;
    drop table if exists cliente cascade;
    drop table if exists enderecos cascade;
    drop table if exists estados cascade;
    drop table if exists genero cascade;
    drop table if exists pais cascade;
    drop table if exists pedidos cascade;
    drop table if exists pessoa cascade;
    drop table if exists telefones cascade;
    drop table if exists tipos_logradouro cascade;
    drop table if exists tipos_residencia cascade;

    create table cidades (
        estado_id bigint,
        id bigserial not null,
        nome varchar(255),
        primary key (id)
    );
    create table cliente (
        id bigserial not null,
        pessoa_id bigint unique,
        email varchar(255),
        senha varchar(255),
        primary key (id)
    );
    create table enderecos (
        principal boolean,
        cidade_id bigint,
        id bigserial not null,
        pedido_id bigint unique,
        pessoa_id bigint unique,
        apelido varchar(255),
        bairro varchar(255),
        cep varchar(255),
        logradouro varchar(255),
        numero varchar(255),
        tipo_logradouro jsonb,
        tipo_residencia jsonb,
        primary key (id)
    );
    create table estados (
        id bigserial not null,
        pais_id bigint,
        nome varchar(255),
        sigla varchar(255),
        primary key (id)
    );
    create table genero (
        id bigserial not null,
        descricao varchar(255) check (descricao in ('MASCULINO','FEMININO','OUTRO')),
        primary key (id)
    );
    create table pais (
        id bigserial not null,
        nome varchar(255),
        primary key (id)
    );
    create table pedidos (
        cliente_id bigint not null unique,
        endereco_id bigint not null unique,
        id bigserial not null,
        numero varchar(255),
        primary key (id)
    );
    create table pessoa (
        data_nascimento timestamp(6),
        genero_id bigint unique,
        id bigserial not null,
        cpf varchar(255),
        nome varchar(255),
        primary key (id)
    );
    create table telefones (
        id bigserial not null,
        pessoa_id bigint not null,
        ddd varchar(255),
        numero varchar(255),
        tipo varchar(255),
        primary key (id)
    );
    create table tipos_logradouro (
        id bigserial not null,
        descricao varchar(255) check (descricao in ('RUA','AVENIDA','TRAVESSA','OUTRO')),
        primary key (id)
    );
    create table tipos_residencia (
        id bigserial not null,
        descricao varchar(255) check (descricao in ('CASA','APARTAMENTO','OUTRO')),
        primary key (id)
    );
    alter table if exists cidades 
       add constraint FKdt0b3ronwpi1upsrhaeq6r69n 
       foreign key (estado_id) 
       references estados;
    alter table if exists cliente 
       add constraint FKje7d3c1jdkexkpnkmx3894wfi 
       foreign key (pessoa_id) 
       references pessoa;
    alter table if exists enderecos 
       add constraint FKi7v6nvtiwatf10fe6c8n7qbde 
       foreign key (cidade_id) 
       references cidades;
    alter table if exists enderecos 
       add constraint FKc6la0cgenglfgria2ictrp5gg 
       foreign key (pedido_id) 
       references pedidos;
    alter table if exists enderecos 
       add constraint FK2cydyr5xb7otrl7go5erq7e10 
       foreign key (pessoa_id) 
       references pessoa;
    alter table if exists estados 
       add constraint FKrm78dlpkss2a2viv4ejjgviai 
       foreign key (pais_id) 
       references pais;
    alter table if exists pedidos 
       add constraint FK6wgk5emlhdcthucnnmi4dpl33 
       foreign key (cliente_id) 
       references cliente;
    alter table if exists pedidos 
       add constraint FKekuochlfkprh1dyhpi3nanalj 
       foreign key (endereco_id) 
       references enderecos;
    alter table if exists pessoa 
       add constraint FKk85t81asvo1ahgnbn452sbox3 
       foreign key (genero_id) 
       references genero;
    alter table if exists telefones 
       add constraint FKpslyamytot17rnmig6ghq4x0l 
       foreign key (pessoa_id) 
       references pessoa;
       
