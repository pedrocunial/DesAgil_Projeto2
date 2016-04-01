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
	private JLabel frameTitle;
	private JComboBox<Object> comboBox; // Sugestão do Matheus Dias
	private String[] portas = {"AND", "OR", "NOT", "XOR", "HalfAdder", "FullAdder"};
	private String[] entradas = {"Ligado", "Desligado"};
	private JComboBox<Object> entradasA;
	private JComboBox<Object> entradasB;
	
	public Screen() {
		frame = new JFrame("Simulador de Portas Lógicas");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Insets insets = frame.getInsets();
		frame.setSize(600 + insets.left + insets.right, 400 + insets.top + insets.bottom);
		
		comboBox = new JComboBox<Object>(portas);
		comboBox.setSelectedIndex(0);
		comboBox.addActionListener(this);
		
		entradasA = new JComboBox<Object>(entradas);
		entradasA.setSelectedIndex(0);
		entradasA.addActionListener(this);
		
		entradasB = new JComboBox<Object>(entradas);
		entradasB.setSelectedIndex(0);
		entradasB.addActionListener(this);
						
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		
		buttonSelecionar = new JButton("Selecionar");
		buttonSelecionar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
			    // Confere o valor da comboBox selecionado no momento
				// Será usado para saber qual porta deverá ser desenhada
			    int i = comboBox.getSelectedIndex();
			    int j = entradasA.getSelectedIndex();
			    int k = entradasB.getSelectedIndex();
			    System.out.println(portas[i]);
			    System.out.println(entradas[j]);
			    System.out.println(entradas[k]);
			
			}
		});
		
		frameTitle = new JLabel("Escolha uma Porta");
		frameTitle.setFont(new Font("", Font.PLAIN, 24));
	
		panel.add(buttonSelecionar);
		panel.add(frameTitle);
		panel.add(comboBox);
		panel.add(entradasA);
		panel.add(entradasB);
		
		Dimension size = buttonSelecionar.getPreferredSize();
		buttonSelecionar.setBounds(20 + insets.left, (400 - size.height * 3) + insets.top, size.width, size.height);
		size = comboBox.getPreferredSize();
		comboBox.setBounds(25 + insets.left, 50 + insets.top, size.width, size.height);
		size = frameTitle.getPreferredSize();
		frameTitle.setBounds((300 - size.width / 2) + insets.left, insets.top, size.width, size.height);
		size = entradasA.getPreferredSize();
		entradasA.setBounds(25 + insets.left, 210 + insets.left, size.width, size.height);
		size = entradasB.getPreferredSize();
		entradasB.setBounds(25 + insets.left, 280 + insets.left, size.width, size.height);
		

		frame.add(panel);
		
	}


	public static void main(String[] args) {
	    // Não sei se você lembra que eu comentei com você que a minha janela
		// ficava cinza quando eu iniciava o programa, achei um problema
		// semelhante com e eis a solução, segue o link que eu encontrei
		// http://stackoverflow.com/questions/12295056/gui-elements-not-showing-until-resize-of-window
		
		SwingUtilities.invokeLater(new Runnable() {
			// Classe anônima
			public void run() {
				new Screen();
			}
	    });
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
