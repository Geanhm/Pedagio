package model;

import java.util.Date;

public class Passantes {
	
	private int id;
	private String veiculo_id;
	private Date dataCadastro;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVeiculo_id() {
		return veiculo_id;
	}
	public void setVeiculo_id(String veiculo_id) {
		this.veiculo_id = veiculo_id;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}
