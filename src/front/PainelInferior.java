package front;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PainelInferior extends JPanel{
	
	private RealizarVenda realizarvenda=new RealizarVenda();
	private ListarVendas listarvendas=new ListarVendas();
	private MostrarRelatorio mostrarrelatorio=new MostrarRelatorio();
	private ListarClientes listarclientes=new ListarClientes();
	
	Color cor=new Color(28, 28, 28);
	
	public PainelInferior(){
		
		setBackground(cor);
		setPreferredSize(new Dimension(800, 695));
		add(realizarvenda);
		add(listarvendas);
		add(mostrarrelatorio);
		add(listarclientes);
	}
	
	public void setVisibilidadeRealizarVendas(boolean v) {
		realizarvenda.setVisible(v);
	}
	
	public void setVisibilidadeListarVendas(boolean v) {
		listarvendas.setVisible(v);
	}
	
	public void setVisibilidadeMostrarRelatorio(boolean v) {
		mostrarrelatorio.setVisible(v);
	}
	
	public void setVisibilidadeListarClientes(boolean v) {
		listarclientes.setVisible(v);
	}
	
	public void atualizarVendas() {
		listarvendas.atualizarVendas();
	}
	
	public void atualizarClientes() {
		listarclientes.atualizarClientes();
	}

}
