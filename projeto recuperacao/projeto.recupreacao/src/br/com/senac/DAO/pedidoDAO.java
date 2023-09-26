package br.com.senac.DAO;

import br.com.senac.infra.ConexaoMysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class pedidoDAO {


    public static void criaPedido(String formaDePagamento) throws SQLException, ClassNotFoundException {
        ConexaoMysql conexaoMysql = new ConexaoMysql();
        Connection conn = conexaoMysql.obterConexao();
        PreparedStatement stmt = null;
        stmt = conn.prepareStatement("INSERT INTO tb_pedido (forma_pagamento) VALUES (?)");
        stmt.setString(1, formaDePagamento);
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }
    public static int obterPedido() throws SQLException, ClassNotFoundException {
        ConexaoMysql conexaoMysql = new ConexaoMysql();
        Connection conn = conexaoMysql.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        stmt = conn.prepareStatement("SELECT MAX(id) AS max_id FROM tb_pedido");
        rs = stmt.executeQuery();
        int ultimoId = 0;
        if (rs.next()){
            ultimoId = rs.getInt("max_id");
        }
        return ultimoId;
    }
}
