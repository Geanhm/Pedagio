package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static String host = "localhost";
	private static String banco = "pedagio";
	private static String usuario = "root";
	private static String senha = "";
	private static String url = "jdbc:mysql://" + host + "/" + banco;
	private static Connection connection = null;
	
	public static Connection getConexao() {
		try {
			connection = DriverManager.getConnection(url, usuario, senha);
		} catch (Exception ex){
			System.out.println("Erro:" + ex.getMessage());
		}
		
		if (connection != null) {
			System.out.println("Conectado com sucesso!");
		} else {
			System.out.println("Não foi possivel realizar a conexão");
		}
		
		return connection;
	}
	
	public boolean fecharConexao () {
		if (connection != null) {
			try {
				connection.close();
				return true;
			} catch (SQLException e) {
				System.out.println("Erro:" + e.getMessage());
			}
		}
		return false;
	}
}
