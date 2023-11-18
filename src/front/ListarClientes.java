package front;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.Controlador;

public class ListarClientes extends JPanel{

	private Color cor=new Color(28, 28, 28);
	private JScrollPane tabela=new JScrollPane();
	private Controlador t=new Controlador();
	
	public ListarClientes() {
		
		setPreferredSize(new Dimension(785, 680));
		setBackground(cor);
	}
	
	public void atualizarClientes() {
		remove(tabela);
		tabela=t.listarClientes();
		add(tabela);
	}
}
