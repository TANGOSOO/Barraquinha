package front;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.Controlador;

public class ListarVendas extends JPanel{

	private Color cor=new Color(28, 28, 28);
	private JScrollPane tabela=new JScrollPane();
	private Controlador t=new Controlador();
	
	public ListarVendas() {
		
		setPreferredSize(new Dimension(785, 680));
		setBackground(cor);
	}
	
	public void atualizarVendas() {
		remove(tabela);
		tabela=t.listarVendas();
		add(tabela);
	}
}
