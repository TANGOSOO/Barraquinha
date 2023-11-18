package front;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import controller.Controlador;

public class TelaDeUpdate extends JFrame implements ActionListener{

	private Color corbotao=new Color(87, 7, 7);
	private Controlador t=new Controlador();
	
	public TelaDeUpdate() {
		
		setSize(new Dimension(500, 150));
		setVisible(true);
		setResizable(false); 
		setLocationRelativeTo(null);
		organizador();
	}
	
	private void organizador() {
		JPanel p=new JPanel();
		p.setBackground(Color.black);
		FlowLayout layout=new FlowLayout();
		layout.setHgap(20);
		layout.setVgap(20);
		p.setLayout(layout);
		add(p);
		BotoesSuperiores b1=new BotoesSuperiores("Atualizar Comprador", corbotao);
		BotoesSuperiores b2=new BotoesSuperiores("Deletar Comprador", corbotao);
		p.add(b2);
		p.add(b1);
		b1.addActionListener(this);
		b2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		BotoesSuperiores b=(BotoesSuperiores) e.getSource();
		if(b.getText().equals("Deletar Comprador")){
			String id=JOptionPane.showInputDialog("Digite o id a ser deletado");
			t.deletarComprador(id);
		}
		if(b.getText().equals("Atualizar Comprador")) {
			String id=JOptionPane.showInputDialog("Digite o id a ser atualizado");
			String nome=JOptionPane.showInputDialog("Digite o novo nome");
			String matricula=JOptionPane.showInputDialog("Digite a nova matricula");
			t.atualizarComprador(id, nome, matricula);
		}
	}
}
