package front;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controlador;

public class MostrarRelatorio extends JPanel{

	private Color cor=new Color(28, 28, 28);
	private JLabel label=new JLabel();
	
	public MostrarRelatorio() {
		
		Controlador c=new Controlador();
		c.listarInformacoes();
		setPreferredSize(new Dimension(785, 680));
		setBackground(cor);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("arial", Font.BOLD, 30));
		label.setText("<html>TOTAL DE CACHORROS QUENTES VENDIDOS: " + c.getCachorrosQuentesVendidos() + "<br/> PROTEÍNA MAIS VENDIDA: "
				+ c.getProteinaMaisVendida() + "<br/> BEBIDA MAIS VENDIDA: " + c.getBebidaMaisVendida() + ""
						+ "<br/> VALOR TOTAL ARRECADADO: R$" + c.getValorTotal() + "</html>");
		add(label);
		setVisible(false);
	}
}
