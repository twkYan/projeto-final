package br.com.senac.DAO;

import br.com.senac.infra.ConexaoMysql;
import br.com.senac.model.Produtomodel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutoDAO {
    public void salvarProduto() {
        Produtomodel produto = new Produtomodel();
        try {
            ConexaoMysql conexaoMysql = new ConexaoMysql();
            Connection conn = conexaoMysql.obterConexao();
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("INSERT INTO tb_produtos(descricao, preco) VALUES (?, ?)");
            stmt.setString(1, produto.getDescricao());
            stmt.setDouble(2, produto.getPreco());
            stmt.executeUpdate();
        } catch (Exception e1) {
            System.err.println(e1.getMessage());

        }
    }
    public static ArrayList<Produtomodel> obterProdutos(int id) throws SQLException, ClassNotFoundException, SQLException {
        ConexaoMysql conexaoMysql = new ConexaoMysql();
        Connection con = conexaoMysql.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        stmt = con.prepareStatement("SELECT id, descricao, preco FROM tb_produtos WHERE id = ?");
        stmt.setInt(1, id);
        rs = stmt.executeQuery();
        ArrayList<Produtomodel> produtosList = new ArrayList();

        while(rs.next()) {
            Produtomodel model = new Produtomodel();
            model.setId(rs.getInt("id"));
            model.setDescricao(rs.getString("descricao"));
            model.setPreco(rs.getFloat("preco"));
            produtosList.add(model);
        }

        return produtosList;
    }
    public static Produtomodel obterPrecoProduto(int id) throws SQLException, ClassNotFoundException, SQLException {
        ConexaoMysql conexaoMysql = new ConexaoMysql();
        Connection con = conexaoMysql.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        stmt = con.prepareStatement("SELECT preco FROM tb_produtos WHERE id = ?");
        stmt.setInt(1, id);
        rs = stmt.executeQuery();
        rs.next();
        Produtomodel model = new Produtomodel();
        model.setPreco(rs.getFloat("preco"));
        return model;
    }
}
