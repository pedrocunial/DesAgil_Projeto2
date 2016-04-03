package desagil.vision;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Screen extends JPanel implements ActionListener {
	
	// Estou fazendo um teste para aprender a usar JFrame, Panel etc
	// https://www.youtube.com/watch?v=GvTZ2Huo0T4 << Tutorial que estou usando
	// e suas respectivas continuações

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel panel;
	private JButton buttonSelecionar;
	private JLabel frameTitle, tituloSwitchA, tituloSwitchB;
	private JComboBox<Object> comboBox; // Sugestão do Matheus Dias
	private static final String[] portas = {"AND", "OR", "NOT", "XOR", "HalfAdder", "FullAdder"};
	private static final String[] entradas = {"Ligado", "Desligado"};
	private JComboBox<Object> entradasA;
	private JComboBox<Object> entradasB;
	private BufferedImage lampadaOn, lampadaOff, currentImage; // Carregar imagens
	private BufferedImage switchOnA, switchOffA, currentSwitchStateA;
	private BufferedImage switchOnB, switchOffB, currentSwitchStateB;
	private JLabel lampada, switchA, switchB; // Usar para inserir no painel
	int frameWidth, frameHeight;
	
	public static String[] getPortas() {
		return portas;
	}
	
	public Screen() {
		frameWidth = 600;
		frameHeight = 500;
				
		comboBox = new JComboBox<Object>(portas);
		comboBox.setSelectedIndex(0);
		comboBox.addActionListener(this);
		
		entradasA = new JComboBox<Object>(entradas);
		entradasA.setSelectedIndex(1);
		entradasA.addActionListener(this);
		
		entradasB = new JComboBox<Object>(entradas);
		entradasB.setSelectedIndex(1);
		entradasB.addActionListener(this);
						
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setLocation(frameWidth, frameHeight);
		
		
		// Abrir as imagens
		try {
			lampadaOn = Image.makeImage("src/img/lampadaOn.jpg");
			lampadaOff = Image.makeImage("src/img/lampadaOff.jpg");
			switchOnA = Image.makeImage("src/img/switchOn.png");
			switchOnB = Image.makeImage("src/img/switchOn.png");
			switchOffA = Image.makeImage("src/img/switchOff.png");
			switchOffB = Image.makeImage("src/img/switchOff.png");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Redimencionar as imagens
		try {
			lampadaOn = Image.resizeBufferedImage(lampadaOn, 50, 50);
			lampadaOff = Image.resizeBufferedImage(lampadaOff, 50, 50);
			switchOnA = Image.resizeBufferedImage(switchOnA, 50, 50);
			switchOnB = Image.resizeBufferedImage(switchOnB, 50, 50);
			switchOffA = Image.resizeBufferedImage(switchOffA, 50, 50);
			switchOffB = Image.resizeBufferedImage(switchOffB, 50, 50);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// Imagens iniciais
		lampada = Image.bufferedImageToJLabel(lampadaOff);
		switchA = Image.bufferedImageToJLabel(switchOffA);
		switchB = Image.bufferedImageToJLabel(switchOffB);
		
		buttonSelecionar = new JButton("Selecionar");
		buttonSelecionar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
			    // Confere o valor da comboBox selecionado no momento
				// Será usado para saber qual porta deverá ser desenhada
			    int i = comboBox.getSelectedIndex();
			    int j = entradasA.getSelectedIndex();
			    int k = entradasB.getSelectedIndex();
			   			    
			    if(entradasA.getSelectedIndex() == 0) {
					currentImage = lampadaOn;
					currentSwitchStateA = switchOnA;
					
				} else {
					currentImage = lampadaOff;
					currentSwitchStateA = switchOffA;

				}
			    
			    if(entradasB.getSelectedIndex() == 0) {
					currentSwitchStateB = switchOnB;
					
				} else {
					currentSwitchStateB = switchOffB;

				}
			    
				lampada.setIcon(new ImageIcon(currentImage));
				switchA.setIcon(new ImageIcon(currentSwitchStateA));
				switchB.setIcon(new ImageIcon(currentSwitchStateB));
				panel.repaint();

		    	panel.getToolkit().sync();
			    
			}
		});


		panel.add(lampada);
		
		frameTitle = new JLabel("Escolha uma Porta");
		frameTitle.setFont(new Font("", Font.PLAIN, 24));
		tituloSwitchA = new JLabel("Seletor A");
		tituloSwitchB = new JLabel("Seletor B");
		
				
		// Adiciona o que criamos no painel
		panel.add(buttonSelecionar);
		panel.add(frameTitle);
		panel.add(comboBox);
		panel.add(entradasA);
		panel.add(entradasB);
		panel.add(tituloSwitchA);
		panel.add(tituloSwitchB);
		panel.add(switchA);
		panel.add(switchB);

		
		frame = new JFrame("Simulador de Portas Lógicas");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Insets insets = frame.getInsets();
		frame.setSize(frameWidth + insets.left + insets.right, frameHeight + insets.top + insets.bottom);
		
		
		// Define a posição do que criamos no painel (poderiamos usar para alterar o tamanho, mas isso "distorceria
		// os icones e textos
		Dimension size = buttonSelecionar.getPreferredSize();
		buttonSelecionar.setBounds(20 + insets.left, (frameHeight - size.height * 3) + insets.top, size.width, size.height);
		
		size = comboBox.getPreferredSize();
		comboBox.setBounds(25 + insets.left, 50 + insets.top, size.width, size.height);
		
		size = frameTitle.getPreferredSize();
		frameTitle.setBounds((300 - size.width / 2) + insets.left, insets.top, size.width, size.height);
		
		size = entradasA.getPreferredSize();
		entradasA.setBounds(25 + insets.left, 250 + insets.top, size.width, size.height);
		size = entradasB.getPreferredSize();
		entradasB.setBounds(25 + insets.left, 350 + insets.top, size.width, size.height);
		
		size = tituloSwitchA.getPreferredSize();
		tituloSwitchA.setBounds(25 + insets.left, 230 + insets.top, size.width, size.height);
		size = tituloSwitchB.getPreferredSize();
		tituloSwitchB.setBounds(25 + insets.left, 330 + insets.top, size.width, size.height);
		
		size = lampada.getPreferredSize();
		lampada.setBounds((frameWidth - size.width * 2) + insets.left, (frameHeight / 2 - size.height * 2) + insets.top, size.width, size.height);
		
		size = switchA.getPreferredSize();
		switchA.setBounds(150 + insets.left, 230 + insets.top, size.width, size.height);
		
		size = switchB.getPreferredSize();
		switchB.setBounds(150 + insets.left, 330 + insets.top, size.width, size.height);
		
        frame.setLocationRelativeTo(null); // Agora a janela abre sempre no meio da tela do computador do usuário, acredito que este tipo de feature fará com que o usuário respeite mais o meu poder de manipular o que aparece ou deixa de aparecer na máquina dele obrigado
        frame.setVisible(true);
		frame.add(panel);
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
