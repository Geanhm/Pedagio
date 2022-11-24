package main;

import java.sql.Connection;
import java.util.Scanner;
import repository.Conexao;

public class main {
	public static void main(String[] args) throws Exception {
		Connection con = Conexao.getConexao();
		Scanner sc = new Scanner(System.in);
		Veiculos veiculo = new Veiculos();
		Passantes passante = new Passantes();
		
		
		if((con != null)) {
			System.out.println("Conexão obtida com sucesso");;
			con.close();
		}	
		
		
		Connection con = Conexao.criarConexao();
		
		System.out.println("Digite uma opção");
		System.out.println("1- Veiculo");
		System.out.println("2- Passantes");
		int selecao = sc.nextInt();
		
		swtich(selecao) {
			case 1: 
			System.out.println("1 - Inserir");
			System.out.println("2- Alterar");
			System.out.println("3- Deletar");
			System.out.println("4- Buscar");
			int crudVeiculo = sc.nextInt();
			
			switch(crudVeiculo) {
				case 1: 
				System.out.println("Digite o modelo:");
				veiculos.setModelo(scanner.next());
				System.out.println("Digite a placa");
				veiculos.setPlaca(scanner.next());
				veiculos.setData(date.now());

				veiculosDAO = new VeiculosDAO();
				veiculosDAO.Inserir();
				break;
				
				case 2:
				System.out.println("Digite o id:");
				veiculo.setId(scanner.next());
				System.out.println("Digite o modelo:");
				veiculo.setModelo(scanner.next());
				System.out.println("Digite a placa");
				veiculo.setPlaca(scanner.next());
				veiculo.setData(date.now());

				veiculosDAO = new VeiculosDAO();
				veiculosDAO.Atualizar();
				break;
				
				case 3: 
				System.out.println("Digite o id:");
				veiculo.setId(scanner.next());
				
				veiculosDAO = new VeiculosDAO();
				veiculosDAO.ExcluirPorId(veiculo.getId);
				break;
				
				case 4: 
				System.out.println("Digite o id:");
				veiculo.setId(scanner.next());
				
				veiculosDAO = new VeiculosDAO();
				veiculosDAO.Atualizar();
				break;
			}
			break;
			
			case 2:
			switch(selecao){
				System.out.println("1- Inserir");
				System.out.println("2- Alterar");
				System.out.println("3- Deletar");
				System.out.println("4- Buscar");
				int crudPassante = sc.nextInt();
				
				switch(crudPassante) {
					case 1: 
					System.out.println("Digite o id do veiculo:");
					passante.setVeiculo_id(scanner.next());
					System.out.println("Digite a nova date");
					passante.setData(date.now());

					passantesDAO = new VeiculosDAO();
					passantesDAO.Inserir();
					break;
			
					case 2: 
					System.out.println("Digite o id:");
					passante.setId(scanner.next());
					System.out.println("Digite o id do veiculo:");
					passante.setVeiculo_id(scanner.next());
					System.out.println("Digite a nova date");
					passante.setDataCadastro(date.now());

					passantesDAO = new VeiculosDAO();
					passantesDAO.Atualizar();
					break;
				
					case 3: 
					System.out.println("Digite o id:");
					passante.setId(scanner.next());
				
					passantesDAO = new VeiculosDAO();
					passantesDAO.ExcluirPorId(passante.getId);
					break;
				
					case 4: 
					System.out.println("Digite o id:");
					passante.setId(scanner.next());
				
					passantesDAO = new VeiculosDAO();
					passantesDAO.Buscar();
					break;
				}
			}
			break;
			
			default: System.out.println("Opção Inválida");
			return;
		}
	}
}
