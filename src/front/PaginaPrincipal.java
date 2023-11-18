package front;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class PaginaPrincipal extends JFrame{

	
	public PaginaPrincipal() {
		organizador();
		setSize(800,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false); 
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void organizador() {
		setLayout(new BorderLayout());
		
		PainelInferior painelinferior=new PainelInferior();
		PainelSuperior painelsuperior=new PainelSuperior(painelinferior);
		
		add(painelsuperior, BorderLayout.NORTH);
		add(painelinferior, BorderLayout.SOUTH);
	}
}
