package br.com.senac.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMysql {
    private String nomeServidor ="127.0.0.1";
    private String usuario = "root";
    private String senha = "731125@Yan";

    private String nomeBancoDados = "db_tchefood";

    public Connection obterConexao() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://" + this.nomeServidor + ":3306/" + this.nomeBancoDados;

        Connection connection = null;

        connection = DriverManager.getConnection(url, usuario, senha);

        return connection;
    }
}
