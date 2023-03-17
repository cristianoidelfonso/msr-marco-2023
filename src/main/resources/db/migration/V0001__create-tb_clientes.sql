create table tb_clientes (
       id bigint not null auto_increment,
       email varchar(255) not null unique,
       nome varchar(255) not null,
       telefone varchar(255) not null,
       primary key (id)
    ) engine=InnoDB;