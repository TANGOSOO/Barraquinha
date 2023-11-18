package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.CompradorDAO;

public class Controlador {
	
	CompradorDAO comp=new CompradorDAO();
	int cachorrosQuentesVendidos;
	int salsicha;
	int linguica;
	int frango;
	int bacon;
	Double valorTotal=0.00;
	int delrio;
	int cocacola;
	int sucoDoChaves;
	String bebidaMaisVendida="";
	String proteinaMaisVendida="";
	
	public int adicionarComprador(String nome, String matricula, String proteina, String queijo, String adicionais, String suco) {
		
		if(nome.equals("")) {
			return 0;
		}else {
			comp.adicionarComprador(nome, Integer.valueOf(matricula), getIntProduto(proteina), getIntProduto(queijo), adicionais, getIntProduto(suco), getValor(proteina));
			return 1;
		}
	}
	
	private int getIntProduto(String nome) {
		if(nome.equals(TipoEnumProteina.SALSICHA.getNome()) || nome.equals(TipoEnumQueijo.MUSSARELA.getNome()) || nome.equals(TipoEnumBebida.COCACOLA.getNome())) {
			return 1;
		}else if(nome.equals(TipoEnumProteina.LINGUICA.getNome()) || nome.equals(TipoEnumQueijo.PRATO.getNome()) || nome.equals(TipoEnumBebida.DELRIO.getNome())) {
			return 2;
		}else if(nome.equals(TipoEnumProteina.FRANGO.getNome()) || nome.equals(TipoEnumQueijo.PARMESAO.getNome()) || nome.equals(TipoEnumBebida.SUCODOCHAVES.getNome())) {
			return 3;
		}else if(nome.equals(TipoEnumProteina.BACON.getNome()) || nome.equals(TipoEnumQueijo.COALHO.getNome())) {
			return 4;
		}
		return 0;
	}
	
	private double getValor(String nome) {
		if(nome.equals(TipoEnumProteina.SALSICHA.getNome())){
			valorTotal+=2.00;
			return 2.00;
		}else if(nome.equals(TipoEnumProteina.LINGUICA.getNome())){
			valorTotal+=3.00;
			return 3.00;
		}else if(nome.equals(TipoEnumProteina.FRANGO.getNome())){
			valorTotal+=2.50;
			return 2.50;
		}else if(nome.equals(TipoEnumProteina.BACON.getNome())){
			valorTotal+=3.50;
			return 3.50;
		}
		return 0;
	}
	
	private String getProteinaString(int i) {
		if(i==1) {
			return TipoEnumProteina.SALSICHA.getNome();
		}else if(i==2) {
			return TipoEnumProteina.LINGUICA.getNome();
		}else if(i==3) {
			return TipoEnumProteina.FRANGO.getNome();
		}else if(i==4) {
			return TipoEnumProteina.BACON.getNome();
		}
		return "";
	}
	
	private String getQueijoString(int i) {
		if(i==1) {
			return TipoEnumQueijo.MUSSARELA.getNome();
		}else if(i==2) {
			return TipoEnumQueijo.PRATO.getNome();
		}else if(i==3) {
			return TipoEnumQueijo.PARMESAO.getNome();
		}else if(i==4) {
			return TipoEnumQueijo.COALHO.getNome();
		}
		return "";
	}
	
	private String getBebidaString(int i) {
		if(i==1) {
			return TipoEnumBebida.COCACOLA.getNome();
		}else if(i==2) {
			return TipoEnumBebida.DELRIO.getNome();
		}else if(i==3) {
			return TipoEnumBebida.SUCODOCHAVES.getNome();
		}
		return "";
	}
	
	private void getQuantidadeBebida(int i) {
		if(i==1) {
			cocacola++;
		}else if(i==2) {
			delrio++;
		}else if(i==3) {
			sucoDoChaves++;
		}
	}
	
	private void getQuantidadeProteina(int i) {
		if(i==1) {
			salsicha++;
		}else if(i==2) {
			linguica++;
		}else if(i==3) {
			frango++;
		}else if(i==4) {
			bacon++;
		}
	}
	
	public JScrollPane listarVendas() {
		
		Color cor=new Color(56, 56, 56);
		ArrayList<Comprador> compradores=comp.selecionarTodosCompradores();
		String [] colunas={"ID", "Nome", "Matricula", "Proteína", "Queijo", "Adicionais", "Suco", "Valor"};
		Object [][] dados=new Object[1000][8];
		
		int i=0;
		for (Comprador com : compradores) {
			dados[i][0]=com.getId();
			dados[i][1]=com.getNome();
			dados[i][2]=com.getMatricula();
			dados[i][3]=getProteinaString(com.cachorroquente.getProteina());
			dados[i][4]=getQueijoString(com.cachorroquente.getQueijo());
			dados[i][5]=com.cachorroquente.getAdicionais();
			dados[i][6]=getBebidaString(com.cachorroquente.getSuco());
			dados[i][7]=com.cachorroquente.getValor();
			i++;
		}
		
		JTable tabela=new JTable(dados, colunas);
		JScrollPane barraRolagem = new JScrollPane(tabela);
		
		barraRolagem.setPreferredSize(new Dimension(785, 680));
		barraRolagem.setForeground(cor);
		
		return barraRolagem;
	}
	
	public JScrollPane listarClientes() {
		
		Color cor=new Color(56, 56, 56);
		ArrayList<Comprador> compradores=comp.selecionarTodosCompradores();
		String [] colunas={"ID", "Nome", "Matricula"};
		Object [][] dados=new Object[1000][3];
		
		int i=0;
		for (Comprador com : compradores) {
			dados[i][0]=com.getId();
			dados[i][1]=com.getNome();
			dados[i][2]=com.getMatricula();
			i++;
		}
		
		JTable tabela=new JTable(dados, colunas);
		JScrollPane barraRolagem = new JScrollPane(tabela);
		
		barraRolagem.setPreferredSize(new Dimension(785, 680));
		barraRolagem.setForeground(cor);
		
		return barraRolagem;
	}
	
	public void listarInformacoes() {
		ArrayList<Comprador> compradores=comp.selecionarTodosCompradores();
		
		for (Comprador com : compradores) {
			cachorrosQuentesVendidos++;
			getQuantidadeProteina(com.cachorroquente.getProteina());
			getQuantidadeBebida(com.cachorroquente.getSuco());
			valorTotal+=getValor(getProteinaString(com.cachorroquente.getProteina()));
		}
		atualizarBebidaMaisVendida();
		atualizarProteinaMaisVendida();
	}
	
	public void deletarComprador(String id) {
		comp.deletarComprador(Integer.valueOf(id));
	}
	
	public void atualizarComprador(String id, String nome, String matricula) {
		comp.atualizarComprador(Integer.valueOf(id), nome, Integer.valueOf(matricula));
	}

	private void atualizarBebidaMaisVendida() {
		
		if(this.delrio>this.cocacola && this.delrio>this.sucoDoChaves) {
			bebidaMaisVendida="Del Rio";
		}else if(this.cocacola>this.sucoDoChaves) {
			bebidaMaisVendida="Coca-Cola";
		}else {
			bebidaMaisVendida="Suco Do Chaves";
		}
	}
	
	private void atualizarProteinaMaisVendida() {
		
		if(this.salsicha>this.linguica && this.salsicha>this.frango && this.salsicha>this.bacon) {
			proteinaMaisVendida="Salsicha";
		}else if(this.linguica>this.frango && this.linguica>this.bacon) {
			proteinaMaisVendida="Linguiça";
		}else if(this.frango>this.bacon){
			proteinaMaisVendida="Frango";
		}else if(this.bacon>this.frango) {
			proteinaMaisVendida="Bacon";
		}
	}
	
	public int getCachorrosQuentesVendidos() {
		return cachorrosQuentesVendidos;
	}

	public void setCachorrosQuentesVendidos(int cachorrosQuentesVendidos) {
		this.cachorrosQuentesVendidos = cachorrosQuentesVendidos;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getProteinaMaisVendida() {
		return proteinaMaisVendida;
	}

	public void setProteinaMaisVendida(String proteinaMaisVendida) {
		this.proteinaMaisVendida = proteinaMaisVendida;
	}

	public String getBebidaMaisVendida() {
		return bebidaMaisVendida;
	}

	public void setBebidaMaisVendida(String bebidaMaisVendida) {
		this.bebidaMaisVendida = bebidaMaisVendida;
	}
}
