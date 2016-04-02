package desagil.vision;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Screen implements ActionListener {
	
	// Estou fazendo um teste para aprender a usar JFrame, Panel etc
	// https://www.youtube.com/watch?v=GvTZ2Huo0T4 << Tutorial que estou usando
	// e suas respectivas continuações
	
	private JFrame frame;
	private JPanel panel;
	private JButton buttonSelecionar;
	private JLabel frameTitle, tituloSwitchA, tituloSwitchB;
	private JComboBox<Object> comboBox; // Sugestão do Matheus Dias
	private String[] portas = {"AND", "OR", "NOT", "XOR", "HalfAdder", "FullAdder"};
	private String[] entradas = {"Ligado", "Desligado"};
	private JComboBox<Object> entradasA;
	private JComboBox<Object> entradasB;
	private BufferedImage lampadaOn, lampadaOff; // Carregar imagens
	private JLabel lampada; // Usar para inserir no painel
	int frameWidth, frameHeight;
	
	
	public Screen() {
		frame = new JFrame("Simulador de Portas Lógicas");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frameWidth = 600;
		frameHeight = 500;
		
		Insets insets = frame.getInsets();
		frame.setSize(frameWidth + insets.left + insets.right, frameHeight + insets.top + insets.bottom);
		
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
			    
			    if(entradasA.getSelectedIndex() == 0) {
					lampada = new JLabel(new ImageIcon(lampadaOn));
				
				} else {
					lampada = new JLabel(new ImageIcon(lampadaOff));
				}
				
			
			}
		});
		
		frameTitle = new JLabel("Escolha uma Porta");
		frameTitle.setFont(new Font("", Font.PLAIN, 24));
		tituloSwitchA = new JLabel("Seletor A");
		tituloSwitchB = new JLabel("Seletor B");
		
		try {                
			lampadaOn = ImageIO.read(new File("src/img/lampadaOn.jpg"));
			lampadaOff = ImageIO.read(new File("src/img/lampadaOff.jpg"));
			
		} catch (IOException ex) {
			System.out.println("Não consegui carrregar as imagens das lampadas");
		}
		
		lampada = new JLabel(new ImageIcon(lampadaOff));
				
		// Adiciona o que criamos no painel
		panel.add(buttonSelecionar);
		panel.add(frameTitle);
		panel.add(comboBox);
		panel.add(entradasA);
		panel.add(entradasB);
		panel.add(tituloSwitchA);
		panel.add(tituloSwitchB);
		panel.add(lampada);
		
		// Define a posição do que criamos no painel (poderiamos usar para alterar o tamanho, mas isso "distorceria
		// os icones e textos
		Dimension size = buttonSelecionar.getPreferredSize();
		buttonSelecionar.setBounds(20 + insets.left, (frameHeight - size.height * 3) + insets.top, size.width, size.height);
		
		size = comboBox.getPreferredSize();
		comboBox.setBounds(25 + insets.left, 50 + insets.top, size.width, size.height);
		
		size = frameTitle.getPreferredSize();
		frameTitle.setBounds((300 - size.width / 2) + insets.left, insets.top, size.width, size.height);
		
		size = entradasA.getPreferredSize();
		entradasA.setBounds(25 + insets.left, 250 + insets.left, size.width, size.height);
		size = entradasB.getPreferredSize();
		entradasB.setBounds(25 + insets.left, 350 + insets.left, size.width, size.height);
		
		size = tituloSwitchA.getPreferredSize();
		tituloSwitchA.setBounds(25 + insets.left, 230 + insets.left, size.width, size.height);
		size = tituloSwitchB.getPreferredSize();
		tituloSwitchB.setBounds(25 + insets.left, 330 + insets.left, size.width, size.height);
		
		size = lampada.getPreferredSize();
		lampada.setBounds((frameWidth - size.width) + insets.left, (frameHeight / 2 - size.height / 2) + insets.left, size.width, size.height);
				
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
