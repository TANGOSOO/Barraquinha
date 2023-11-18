package front;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class BotoesSuperiores extends JButton{

	
	public BotoesSuperiores(String nome, Color cor) {
		
		setName(nome);
		setText(nome);
		setOpaque(true);
		setBackground(cor);
		setFont(new Font("arial", Font.BOLD, 15));
		setForeground(Color.WHITE);
	}
}
