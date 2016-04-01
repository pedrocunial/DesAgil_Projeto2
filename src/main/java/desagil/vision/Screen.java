package desagil.vision;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Screen implements ActionListener{
	
	// Estou fazendo um teste para aprender a usar JFrame, Panel etc
	// https://www.youtube.com/watch?v=GvTZ2Huo0T4 << Tutorial que estou usando
	// e suas respectivas continuações
	
	private JFrame frame;
	private JPanel panel;
	private JButton buttonSelecionar;
	private JButton buttonOr;
	private JLabel labelA;
	private JComboBox<Object> comboBox; // Sugestão do Matheus Dias
	private String[] portas = {"AND", "OR", "NOT", "XOR", "HalfAdder", "FullAdder"};
	
	public Screen() {
		gui();
	
	}


	public void gui() {
		 comboBox = new JComboBox<Object>(portas);
		 comboBox.setSelectedIndex(0);
		 comboBox.addActionListener(this);
		 
		 frame = new JFrame("Simulador de Portas Lógicas");
		 frame.setVisible(true);
		 frame.setSize(600, 400); // (Largura, altura)
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 panel = new JPanel();
		 panel.setBackground(Color.WHITE);
		 
		 buttonSelecionar = new JButton("AND");
		 buttonOr = new JButton("OR");
		 labelA = new JLabel("Escolha uma porta");		 
		
		 panel.add(buttonSelecionar);
		 panel.add(buttonOr);
		 panel.add(labelA);
		 panel.add(comboBox);
		 
		 frame.add(panel);
		 
	}
	
	public static void main(String[] args) {
		new Screen();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
