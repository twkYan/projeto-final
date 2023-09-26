create database db_tchefood;
use db_tchefood;

-- tabela pedido
CREATE TABLE tb_pedido(
id		int primary key auto_increment,
forma_pagamento varchar(50)
);

-- tabela produtos
CREATE TABLE tb_produtos(
id		int primary key auto_increment,
descricao varchar(200),
preco int not null
);


-- Tabela ItensPedido
CREATE TABLE tb_ItensPedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pedidoId INT,
    produtoId INT,
    quantidade INT,
    precoUnitario DECIMAL(10, 2),
    FOREIGN KEY (pedidoId) REFERENCES tb_pedido(id),
    FOREIGN KEY (produtoId) REFERENCES tb_produtos(id)
);

-- insers de teste
INSERT INTO tb_produtos (descricao, preco) VALUES ('Hambúrguer', 20);
INSERT INTO tb_produtos (descricao, preco) VALUES ('Batatas Fritas', 5);
INSERT INTO tb_produtos (descricao, preco) VALUES ('Refrigerante', 5);
INSERT INTO tb_produtos (descricao, preco) VALUES ('Sundae', 12);
INSERT INTO tb_produtos (descricao, preco) VALUES ('Cachorro-Quente', 10);
