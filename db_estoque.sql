create schema db_estoque;

use db_estoque;

create table clientes(
id_cliente int auto_increment primary key not null,
nome varchar(300) not null,
cpf bigint not null,
email varchar(300) not null, 
telefone bigint not null
);

create table produtos(
id_produto int auto_increment primary key not null,
nome_produto varchar(100) not null,
quantidade_estoque int not null,
valor double not null,
fornecedor varchar(70) not null
);

create table compras (
    id_compra int auto_increment primary key not null,
    id_cliente int not null,
    id_produto int not null,
    quantidade_comprada int not null,
    data_compra date not null,
    
    foreign key (id_cliente) references clientes (id_cliente),
    foreign key (id_produto) references produtos (id_produto)
);

-- Inserindo os dados dos clientes

insert into clientes (id_cliente, nome, cpf, email, telefone) values 
(0, "Gustavo", 12345, "gustavo@gmail.com", 12345 ),
(0, "Nicolas", 54321, "nicolas@gmail.com", 54321),
(0, "Luan", 56789, "luan@gmail.com", 56789),
(0, "Bianca", 98765, "bianca@gmail.com", 98765),
(0, "Carolina", 55555, "carol@gmail.com", 55555);

-- Inserindo os dados dos produtos

insert into produtos (nome_produto, quantidade_estoque, valor, fornecedor) values 
("HD", 50, 199.99, "Seagate"),
("SSD", 30, 149.99, "Samsung"),
("Monitor", 20, 299.99, "AOC"),
("Mous", 100, 29.99, "Logitech"),
("Teclado", 50, 79.99, "Corsair");
