package front;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PainelSuperior extends JPanel implements ActionListener{
	
	private Color corbotao=new Color(87, 7, 7);
	private Color cor=new Color(28, 28, 28);
	private PainelInferior painelinferior;
	
	public PainelSuperior(PainelInferior painelinferior) {
		
		this.painelinferior=painelinferior;
		
		FlowLayout fl=new FlowLayout();
		fl.setVgap(15);
		
		setLayout(fl);
		setPreferredSize(new Dimension(800, 60));
		setBackground(cor);
		
		add(criarBotao("Realizar Venda"));
		add(criarBotao("Listar Vendas"));
		add(criarBotao("Mostrar Relatorio"));
		add(criarBotao("Listar Clientes"));
	}
	
	public BotoesSuperiores criarBotao(String texto) {
		
		BotoesSuperiores b=new BotoesSuperiores(texto, corbotao);
		b.addActionListener(this);
		return b;
	}

	public void actionPerformed(ActionEvent e) {
		
		JButton b=(JButton) e.getSource();
		
		if(b.getName().equals("Realizar Venda")) {
			this.painelinferior.setVisibilidadeRealizarVendas(true);
			this.painelinferior.setVisibilidadeListarVendas(false);
			this.painelinferior.setVisibilidadeMostrarRelatorio(false);
			this.painelinferior.setVisibilidadeListarClientes(false);
		}else if(b.getName().equals("Listar Vendas")) {
			this.painelinferior.setVisibilidadeRealizarVendas(false);
			this.painelinferior.setVisibilidadeListarVendas(true);
			this.painelinferior.setVisibilidadeMostrarRelatorio(false);
			this.painelinferior.setVisibilidadeListarClientes(false);
			this.painelinferior.atualizarVendas();
		}else if(b.getName().equals("Mostrar Relatorio")) {
			this.painelinferior.setVisibilidadeRealizarVendas(false);
			this.painelinferior.setVisibilidadeListarVendas(false);
			this.painelinferior.setVisibilidadeMostrarRelatorio(true);
			this.painelinferior.setVisibilidadeListarClientes(false);
		}else if(b.getName().equals("Listar Clientes")) {
			this.painelinferior.setVisibilidadeRealizarVendas(false);
			this.painelinferior.setVisibilidadeListarVendas(false);
			this.painelinferior.setVisibilidadeMostrarRelatorio(false);
			this.painelinferior.setVisibilidadeListarClientes(true);
			this.painelinferior.atualizarClientes();
		}
	}
}
