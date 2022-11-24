package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import model.Veiculos;

import java.sql.Statement;
import repository.Conexao;

public class VeiculosDao {

	public void inserir() {
		String sql = "INSERT INTO veiculos (modelo, placa, data) VALUES(?,?,?)";
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		
		try {
			connection = Conexao.getConexao();
			
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, "modelo");
			stmt.setString(2, "placa");
			stmt.setDate(3, java.sql.Date);
			
		} catch (SQLException u) {
			throw new RuntimeException (u);
		}
	}
	
	public void listar(){
		
		String sql = "SELECT * FROM veiculos";
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			con = Conexao.getConexao();
			pstm = (PreparedStatement) con.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				int id = rset.getInt("id");
				String modelo = rset.getString("modelo");
				String placa = rset.getString("placa");
				Date dataCadastro = rset.getDate("dataCadastro");
				System.out.format("%d, %s, %s, %tl", id, modelo, placa, dataCadastro);
			} 
		}catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
		}	
	}
	
	public void atualizar(Veiculos veiculo) {
		
		String sql = "UPDATE veiculos SET modelo = ?, placa = ?"
				+ "WHERE = ?";
		
		Connection con = null;
		PreparedStatement  pstm = null;
		
		try {
			con = Conexao.getConexao();
			
			pstm = (PreparedStatement) con.prepareStatement(sql);
			pstm.setString(1, veiculo.getModelo());
			pstm.setString(2, veiculo.getPlaca());
						
			pstm.setInt(3, veiculo.getId());
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(con!=null) {
					con.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void excluirPorId(int id) {
		String sql = "DELETE FROM veiculos WHERE id = ?";

		Connection con = null;
		PreparedStatement  pstm = null;
		
		try {
			con = Conexao.getConexao();
			
			pstm = (PreparedStatement) con.prepareStatement(sql);
						
			pstm.setInt(1, id);
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(con!=null) {
					con.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}
}
