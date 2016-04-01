package desagil.vision;

import javax.swing.*;
import java.awt.*;


public class Screen {
	
	// Estou fazendo um teste para aprender a usar JFrame, Panel etc
	// https://www.youtube.com/watch?v=GvTZ2Huo0T4 << Tutorial que estou usando
	// e suas respectivas continuações
	
	private JFrame frame;
	private JPanel panel;
	private JButton buttonA;
	private JLabel labelA;
	
	public Screen() {
		gui();
	
	}

	public void gui() {
		 frame = new JFrame("Simulador de Portas Lógicas");
		 frame.setVisible(true);
		 frame.setSize(600, 400); // (Largura, altura)
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 panel = new JPanel();
		 panel.setBackground(Color.WHITE);
		 
		 buttonA = new JButton("Test");
		 labelA = new JLabel("Escolha uma porta");		 
		 
		 panel.add(buttonA);
		 panel.add(labelA);
		 
		 frame.add(panel, BorderLayout.SOUTH);
		 
	}
	
	public static void main(String[] args) {
		new Screen();
	}
	
}
