package br.com.senac.DAO;

import br.com.senac.infra.ConexaoMysql;

import java.sql.*;
import java.util.List;

import br.com.senac.model.CarrinhoDeCompras;
import br.com.senac.model.ItensPedidoModel;
import br.com.senac.model.PedidoModel;

public class itenspedidoDAO {
   public static void salvar(List<ItensPedidoModel> car) {
       try {
           ConexaoMysql conexaoMysql = new ConexaoMysql();
           Connection conn = conexaoMysql.obterConexao();
           PreparedStatement stmt = null;

           ;
           for (ItensPedidoModel item : car) {
                stmt = conn.prepareStatement("INSERT INTO tb_itenspedido (pedidoId, produtoId, quantidade, precoUnitario) VALUES (?, ?, ?, ?)");
                stmt.setInt(1, pedidoDAO.obterPedido());
                stmt.setInt(2, item.getProdutoid());
                stmt.setInt(3, item.getQuantidade());
                stmt.setDouble(4, item.getProcoUnitario());
                stmt.executeUpdate();
          }
     } catch (SQLException e) {
         throw new RuntimeException(e);
      } catch (ClassNotFoundException e) {
         throw new RuntimeException(e);
       }
  }
}