package front;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controller.Controlador;

public class RealizarVenda extends JPanel implements ActionListener{
	
	private Color cor=new Color(28, 28, 28);
	private Color corbox=new Color(56, 56, 56);
	private Color corbotao=new Color(87, 7, 7);
	private JTextField nomeTextField;
	private JTextField matriculaTextField;
	private JComboBox proteinaComboBox;
	private JComboBox queijoComboBox;
	private JComboBox sucoComboBox;
	private JCheckBox maioneseCheckBox;
	private JCheckBox ketchupCheckBox;
	private JCheckBox ovoCheckBox;
	private JCheckBox batataCheckBox;
	private ArrayList<JCheckBox> arrayCheckBox=new ArrayList<JCheckBox>();
	private JButton finalizarButton;
	private Controlador t=new Controlador();
	
	public RealizarVenda() {
		
		GridLayout grid=new GridLayout(7, 2);
		grid.setVgap(50);
		setLayout(grid);
		setPreferredSize(new Dimension(785, 690));
		setBackground(cor);
		setVisible(true);
		
		criador();
	}
	
	private void criador() {
		
		nomeTextField=configurarTextField();
		matriculaTextField=configurarTextField();
		proteinaComboBox=configurarComboBox("Salsicha", "Linguiça", "Frango", "Bacon");
		queijoComboBox=configurarComboBox("Mussarela", "Prato", "Parmesão", "Coalho");
		sucoComboBox=configurarComboBox("Coca-Cola", "Del Rio", "Suco do Chaves");
		configurarAdicionais("Maionese", "Ketchup", "Ovo", "Batata-Palha");
		
		add(criarLabel("Nome do Cliente:"));
		add(nomeTextField);
		add(criarLabel("Matricula:"));
		add(matriculaTextField);
		add(criarLabel("Opção de Proteína:"));
		add(proteinaComboBox);
		add(criarLabel("Opção de Queijo:"));
		add(queijoComboBox);
		add(criarLabel("Escolha os Adicionais:"));
		add(adicionarAdicionais());
		add(criarLabel("Opção de Bebida:"));
		add(sucoComboBox);
		add(criarBotao("Atualizar Dados"));
		add(criarBotao("Realizar Venda"));
	}

	private JComboBox configurarComboBox(String a, String b, String c, String d) {
		
		JComboBox co=new JComboBox();
		co.setFont(new Font("Arial", Font.BOLD, 15));
		co.setBackground(corbox);
		co.setForeground(Color.WHITE);
		
		co.addItem(a);
		co.addItem(b);
		co.addItem(c);
		co.addItem(d);
		
		return co;
	}
	
	private JComboBox configurarComboBox(String a, String b, String c) {
		
		JComboBox co=new JComboBox();
		co.setFont(new Font("Arial", Font.BOLD, 15));
		co.setBackground(corbox);
		co.setForeground(Color.WHITE);
		
		co.addItem(a);
		co.addItem(b);
		co.addItem(c);
		
		return co;
	}

	private JLabel criarLabel(String texto) {
		
		JLabel l=new JLabel(texto);
		l.setBackground(cor);
		l.setFont(new Font("arial", Font.BOLD, 20));
		l.setForeground(Color.WHITE);
		
		return l;
	}
	
	private JTextField configurarTextField() {
		
		JTextField tf=new JTextField();
		
		tf.setBackground(corbox);
		tf.setFont(new Font("Arial", Font.BOLD, 15));
		tf.setForeground(Color.WHITE);
		
		return tf;
	}
	
	private void configurarAdicionais(String a, String b, String c, String d) {
		
		JPanel p=new JPanel();
		
		p.setLayout(new GridLayout(2,2));
		p.setBackground(cor);
		
		maioneseCheckBox=new JCheckBox(a);
		ketchupCheckBox=new JCheckBox(b);
		ovoCheckBox=new JCheckBox(c);
		batataCheckBox=new JCheckBox(d);
		
		maioneseCheckBox.setFont(new Font("Arial", Font.BOLD, 12));
		ketchupCheckBox.setFont(new Font("Arial", Font.BOLD, 12));
		ovoCheckBox.setFont(new Font("Arial", Font.BOLD, 12));
		batataCheckBox.setFont(new Font("Arial", Font.BOLD, 12));
		
		maioneseCheckBox.setBackground(cor);
		ketchupCheckBox.setBackground(cor);
		ovoCheckBox.setBackground(cor);
		batataCheckBox.setBackground(cor);
		
		maioneseCheckBox.setForeground(Color.WHITE);
		ketchupCheckBox.setForeground(Color.WHITE);
		ovoCheckBox.setForeground(Color.WHITE);
		batataCheckBox.setForeground(Color.WHITE);
		
		arrayCheckBox.add(maioneseCheckBox);
		arrayCheckBox.add(ketchupCheckBox);
		arrayCheckBox.add(ovoCheckBox);
		arrayCheckBox.add(batataCheckBox);
		
		p.add(maioneseCheckBox);
		p.add(ketchupCheckBox);
		p.add(ovoCheckBox);
		p.add(batataCheckBox);
	}
	
	private JPanel adicionarAdicionais() {
		
		JPanel p=new JPanel();
		
		p.setLayout(new GridLayout(2,2));
		p.setBackground(cor);
		p.add(maioneseCheckBox);
		p.add(ketchupCheckBox);
		p.add(ovoCheckBox);
		p.add(batataCheckBox);
		
		return p;
	}
	
	private JButton criarBotao(String texto) {
		
		JButton b=new JButton(texto);
		b.setName(texto);
		b.setBackground(corbotao);
		b.setForeground(Color.WHITE);
		b.setFont(new Font("Arial", Font.BOLD, 15));
		b.addActionListener(this);
		
		return b;
	}

	public void actionPerformed(ActionEvent e) {
		
		JButton b=(JButton) e.getSource();
		
		if(b.getName().equals("Realizar Venda")) {
			String nome = nomeTextField.getText();
			String matricula = matriculaTextField.getText();
			String proteina = proteinaComboBox.getSelectedItem().toString();
			String queijo = queijoComboBox.getSelectedItem().toString();
			String suco = sucoComboBox.getSelectedItem().toString();
			String adicionais="";
			
			for (JCheckBox jCheckBox : arrayCheckBox) {
				if(jCheckBox.isSelected()==true) {
					adicionais+=jCheckBox.getText().toString() + " ";
				}
			}
			
			int x=t.adicionarComprador(nome, matricula, proteina, queijo, adicionais, suco);
			
			if(x==1) {
				JOptionPane.showMessageDialog (null, "Compra realizada com sucesso");
			}else {
				JOptionPane.showMessageDialog (null, "Compra negada. Revise os dados");
			}
		}
		if(b.getName().equals("Atualizar Dados")) {
			new TelaDeUpdate();
		}
	}
}
