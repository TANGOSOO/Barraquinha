package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import controller.CachorroQuente;
import controller.Comprador;

public class CompradorDAO {

	public ArrayList<Comprador> selecionarTodosCompradores(){
		
		ArrayList<Comprador> compradores=new ArrayList<Comprador>();
		try {
			Connection conexao=new Conexao().getConexao();
	
			String query="select * from cachorro_quente";
			ResultSet dados=conexao.prepareStatement(query).
			executeQuery();
			
			while(dados.next()) {
				int id=dados.getInt("id_cachorro_quente");
				String nome=dados.getString("nome");
				int matricula= dados.getInt("matricula");
				int proteina=dados.getInt("op_proteina");
				int queijo=dados.getInt("op_queijo");
				int suco=dados.getInt("bebida");
				String adicionais=dados.getString("ingredientes");
				double valor=dados.getDouble("valor");
				
				CachorroQuente cq=new CachorroQuente(proteina, queijo, suco, adicionais, valor);
				
				Comprador a = new Comprador(id, nome, matricula, cq);
				compradores.add(a);
			}
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return compradores;
	}
	
	public ArrayList<Comprador> selecionarDadosClientes(){
		
		ArrayList<Comprador> clientes=new ArrayList<Comprador>();
		try {
			Connection conexao=new Conexao().getConexao();
	
			String query="select id_cachorro_quente,nome,matricula from cachorro_quente";
			ResultSet dados=conexao.prepareStatement(query).
			executeQuery();
			
			while(dados.next()) {
				int id=dados.getInt("id_cachorro_quente");
				String nome=dados.getString("nome");
				int matricula= dados.getInt("matricula");;
				
				Comprador a = new Comprador(id, nome, matricula);
				clientes.add(a);
			}
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return clientes;
	}
	
	public void adicionarComprador(String nome, int matricula, int proteina, int queijo, String adicionais, int suco, Double valor) {
		
		CachorroQuente cq=new CachorroQuente(proteina, queijo, suco, adicionais, valor);
		Comprador com=new Comprador(nome, matricula, cq);
		Connection conexao=new Conexao().getConexao();
		
		String sql="INSERT INTO cachorro_quente (nome, matricula, op_queijo, op_proteina, ingredientes, bebida, valor) VALUES(?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement statement=(PreparedStatement) conexao.prepareStatement(sql);
			
			statement.setString(1, com.getNome());
			statement.setInt(2, com.getMatricula());
			statement.setInt(4, com.cachorroquente.getQueijo());
			statement.setInt(3, com.cachorroquente.getProteina());
			statement.setString(5, com.cachorroquente.getAdicionais());
			statement.setInt(6, com.cachorroquente.getSuco());
			statement.setDouble(7, com.cachorroquente.getValor());
			
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletarComprador(int id) {
		Connection conexao=new Conexao().getConexao();
		String sql="delete from cachorro_quente where id_cachorro_quente=?";
		try {
			PreparedStatement statement=(PreparedStatement) conexao.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizarComprador(int id, String novoNome, int novaMatricula) {
		
		try {
			Connection conexao=new Conexao().getConexao();
			String sql="update cachorro_quente set nome=?, matricula=? where id_cachorro_quente=?";
			PreparedStatement statement=(PreparedStatement) conexao.prepareStatement(sql);
			statement.setString(1, novoNome);
			statement.setInt(2, novaMatricula);
			statement.setInt(3, id);

			statement.executeUpdate();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}