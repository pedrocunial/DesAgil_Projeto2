package desagil.vision;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Screen implements ActionListener{
	
	// Estou fazendo um teste para aprender a usar JFrame, Panel etc
	// https://www.youtube.com/watch?v=GvTZ2Huo0T4 << Tutorial que estou usando
	// e suas respectivas continuações
	
	private static JFrame frame;
	private JPanel panel;
	private JButton buttonSelecionar;
	private JLabel frameTitle;
	private JComboBox<Object> comboBox; // Sugestão do Matheus Dias
	private String[] portas = {"AND", "OR", "NOT", "XOR", "HalfAdder", "FullAdder"};
	
	public Screen() {
		frame = new JFrame("Simulador de Portas Lógicas");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Insets insets = frame.getInsets();
		frame.setSize(300 + insets.left + insets.right,
	              150 + insets.top + insets.bottom);
		
		comboBox = new JComboBox<Object>(portas);
		comboBox.setSelectedIndex(0);
		comboBox.addActionListener(this);
				
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		
		buttonSelecionar = new JButton("Selecionar");
		
		frameTitle = new JLabel("Escolha uma porta");		 
	
		panel.add(buttonSelecionar);
		panel.add(frameTitle);
		panel.add(comboBox);
		
		Dimension size = buttonSelecionar.getPreferredSize();
		buttonSelecionar.setBounds(20 + insets.left,
				20 + insets.top, size.width, size.height);
		size = comboBox.getPreferredSize();
		comboBox.setBounds(25 + insets.left,
				50 + insets.top, size.width, size.height);
		size = frameTitle.getPreferredSize();
		frameTitle.setBounds(12 + insets.left,
				insets.top, size.width, size.height);
		
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
