package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import model.Passantes;
import model.Veiculos;
import repository.Conexao;

public class PassantesDao {
	
	public void inserir() {
		String sql = "INSERT INTO passantes (veiculo_id, dataCadastro) VALUES(?, ?)";
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		
		try {
			connection = Conexao.getConexao();
			
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, "veiculo_id");
			stmt.setDate(2, java.sql.Datee);
			
		} catch (SQLException u) {
			throw new RuntimeException (u);
		}
	}
	
	public void listar(){
		
		String sql = "SELECT * FROM passantes";
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			con = Conexao.getConexao();
			pstm = (PreparedStatement) con.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				int id = rset.getInt("id");
				String veiculo_id = rset.getString("veiculo_id");
				Date dataCadastro = rset.getDate("dataCadastro");
				System.out.format("%d, %s, %tl", id, veiculo_id, dataCadastro);
			} 
		}catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
		}	
	}
	
	public void atualizar(Passantes passante) {
		
		String sql = "UPDATE passantes SET veiculo_id = ?, dataCadastro = ?"
				+ "WHERE = ?";
		
		Connection con = null;
		PreparedStatement  pstm = null;
		
		try {
			con = Conexao.getConexao();
			
			pstm = (PreparedStatement) con.prepareStatement(sql);
			pstm.setString(1, passante.getVeiculo_id());
			pstm.setDate(2, (java.sql.Date) passante.getDataCadastro());
						
			pstm.setInt(3, passante.getId());
			
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
		String sql = "DELETE FROM passantes WHERE id = ?";

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
