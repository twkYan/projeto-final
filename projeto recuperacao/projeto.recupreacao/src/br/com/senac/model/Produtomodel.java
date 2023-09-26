package br.com.senac.model;

import br.com.senac.infra.ConexaoMysql;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Produtomodel {
    int id;
    String descricao;
    double preco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
//model utilizado apenas para teste de conexao
