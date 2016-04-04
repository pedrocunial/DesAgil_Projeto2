package desagil.vision;

import javax.swing.*;

import desagil.model.AndGate;
import desagil.model.FullAdder;
import desagil.model.HalfAdder;
import desagil.model.InputPin;
import desagil.model.Lamp;
import desagil.model.LogicGate;
import desagil.model.NotGate;
import desagil.model.OrGate;
import desagil.model.Switch;
import desagil.model.XorGate;


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
	private JButton buttonSelecionar, buttonConfirmarPorta;
	private JLabel frameTitle, tituloSwitchA, tituloSwitchB, tituloSwitchC;
	private JComboBox<Object> comboBox; // Sugestão do Matheus Dias
	private static final String[] portas = {"AND", "OR", "NOT", "XOR", "HalfAdder", "FullAdder"};
//	private static final String[] entradas = {"Ligado", "Desligado"};
//	private JComboBox<Object> entradasA;
//	private JComboBox<Object> entradasB;
//	private JComboBox<Object> entradasC;
//	private BufferedImage lampadaOn, lampadaOff, currentImage, currentImageB; // Carregar imagens
	private BufferedImage switchOnA, switchOffA, currentSwitchStateA;
	private BufferedImage switchOnB, switchOffB, currentSwitchStateB;
	private BufferedImage switchOnC, switchOffC, currentSwitchStateC;
//	private JLabel lampadaA, lampadaB;
	private JLabel switchA, switchB, switchC; // Usar para inserir no painel
	private int frameWidth, frameHeight;
	private LogicGate[] objetoDasPortas = new LogicGate[6];
	private boolean switchValueA, switchValueB, switchValueC;
	private LogicGate currentGate;
	private InputPin pinA, pinB, pinC;
	private Switch inA, inB, inC;
	private int doorStyle;
	private JCheckBox checkBoxA, checkBoxB, checkBoxC;
	private JCheckBox saidaA, saidaB;
	private InputPin pinLampA, pinLampB;
	private Lamp lampA, lampB;
	
	
	
	public Screen() {
		frameWidth = 600;
		frameHeight = 500;
		
		lampA = new Lamp();
		lampB = new Lamp();
		
		pinLampA = new InputPin();
		pinLampB = new InputPin();
		
		checkBoxA = new JCheckBox();
		checkBoxB = new JCheckBox();
		checkBoxC = new JCheckBox();
		
		saidaA = new JCheckBox();
		saidaA.setEnabled(false);
		
		saidaB = new JCheckBox();
		saidaB.setEnabled(false);
		
		objetoDasPortas[0] = new AndGate();
		objetoDasPortas[1] = new OrGate();
		objetoDasPortas[2] = new NotGate();
		objetoDasPortas[3] = new XorGate();
		objetoDasPortas[4] = new HalfAdder();
		objetoDasPortas[5] = new FullAdder();
				
		comboBox = new JComboBox<Object>(portas);
		comboBox.setSelectedIndex(0);
		comboBox.addActionListener(this);
		
//		entradasA = new JComboBox<Object>(entradas);
//		entradasA.setSelectedIndex(1);
//		entradasA.addActionListener(this);
//		
//		entradasB = new JComboBox<Object>(entradas);
//		entradasB.setSelectedIndex(1);
//		entradasB.addActionListener(this);
//		
//		entradasC = new JComboBox<Object>(entradas);
//		entradasC.setSelectedIndex(1);
//		entradasC.addActionListener(this);
						
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setLocation(frameWidth, frameHeight);
		
		
		// Abrir as imagens
		try {
//			lampadaOn = Image.makeImage("src/img/lampadaOn.jpg");
//			lampadaOff = Image.makeImage("src/img/lampadaOff.jpg");
			switchOnA = Image.makeImage("src/img/switchOn.png");
			switchOnB = Image.makeImage("src/img/switchOn.png");
			switchOnC = Image.makeImage("src/img/switchOn.png");
			switchOffA = Image.makeImage("src/img/switchOff.png");
			switchOffB = Image.makeImage("src/img/switchOff.png");
			switchOffC = Image.makeImage("src/img/switchOff.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Redimencionar as imagens
		try {
//			lampadaOn = Image.resizeBufferedImage(lampadaOn, 50, 50);
//			lampadaOff = Image.resizeBufferedImage(lampadaOff, 50, 50);
			switchOnA = Image.resizeBufferedImage(switchOnA, 50, 50);
			switchOnB = Image.resizeBufferedImage(switchOnB, 50, 50);
			switchOnC = Image.resizeBufferedImage(switchOnC, 50, 50);
			switchOffA = Image.resizeBufferedImage(switchOffA, 50, 50);
			switchOffB = Image.resizeBufferedImage(switchOffB, 50, 50);
			switchOffC = Image.resizeBufferedImage(switchOffC, 50, 50);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		switchValueA = false;
		switchValueB = false;
		switchValueC = false;
		currentGate = objetoDasPortas[comboBox.getSelectedIndex()];
		doorStyle = 0;
		
		inA = new Switch();
		inB = new Switch();
		inC = new Switch();
		
		// Imagens iniciais
//		lampadaB = Image.bufferedImageToJLabel(lampadaOff);
//		lampadaA = Image.bufferedImageToJLabel(lampadaOff);
		switchA = Image.bufferedImageToJLabel(switchOffA);
		switchB = Image.bufferedImageToJLabel(switchOffB);
		switchC = Image.bufferedImageToJLabel(switchOffC);
		
		pinA = new InputPin();
		pinB = new InputPin();
		pinC = new InputPin();
		doorStyle = 0;
		
		buttonConfirmarPorta = new JButton("Confirmar");
		buttonConfirmarPorta.addActionListener(new ActionListener() {
			// Descobre o tipo de porta que é para definir o número de 
			// entradas e saídas			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex() == 2) {
					// Not
					doorStyle = 1;
				
				} else if(comboBox.getSelectedIndex() == 4) {
					// HalfAdder
					doorStyle = 2;
					
				} else if(comboBox.getSelectedIndex() == 5) {
					// FullAdder
					doorStyle = 3;
				
				} else {
					// Portas Básicas e Xor
					doorStyle = 0;
				
				}
				criaPainel();
				
			}
		});
		
		
		buttonSelecionar = new JButton("Selecionar");
		buttonSelecionar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				// Confere o tipo de porta para saber quantas entradas serão usadas
				defineLogica();
			}
		});

		
		frameTitle = new JLabel("Escolha uma Porta");
		frameTitle.setFont(new Font("", Font.PLAIN, 24));
		tituloSwitchA = new JLabel("Seletor A");
		tituloSwitchB = new JLabel("Seletor B");
		tituloSwitchC = new JLabel("Seletor C");
		
				
		// Adiciona o que criamos no painel
		panel.add(buttonConfirmarPorta);
		panel.add(buttonSelecionar);
		panel.add(frameTitle);
		panel.add(comboBox);
		
		frame = new JFrame("Simulador de Portas Lógicas");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Insets insets = frame.getInsets();
		frame.setSize(frameWidth + insets.left + insets.right, frameHeight + insets.top + insets.bottom);
		
		
		// Define a posição do que criamos no painel (poderiamos usar para alterar o tamanho, mas isso "distorceria
		// os icones e textos
		Dimension size = comboBox.getPreferredSize();
		comboBox.setBounds((frameWidth / 2 - size.width - 8) + insets.left, 50 + insets.top, size.width, size.height);
		
		size = buttonConfirmarPorta.getPreferredSize();
		buttonConfirmarPorta.setBounds((frameWidth / 2 + 5) + insets.left, 49 + insets.top, size.width, size.height);
		
		size = frameTitle.getPreferredSize();
		frameTitle.setBounds((300 - size.width / 2) + insets.left, insets.top, size.width, size.height);
		
		size = buttonSelecionar.getPreferredSize();
		buttonSelecionar.setBounds(20 + insets.left, (frameHeight - size.height * 3) + insets.top, size.width, size.height);
		
		// Portas básicas e Xor
//		panel.add(entradasA);
//		panel.add(entradasB);
		panel.add(tituloSwitchA);
		panel.add(tituloSwitchB);
		panel.add(switchA);
		panel.add(switchB);
//		panel.add(lampadaA);
		panel.add(checkBoxA);
		panel.add(checkBoxB);
		panel.add(saidaA);
		
		size = checkBoxA.getPreferredSize();
		checkBoxA.setBounds(25 + insets.left, 180 + insets.top, size.width, size.height);
		size = checkBoxB.getPreferredSize();
		checkBoxB.setBounds(25 + insets.left, 300 + insets.top, size.width, size.height);
		
//		size = entradasA.getPreferredSize();
//		entradasA.setBounds(25 + insets.left, 180 + insets.top, size.width, size.height);
//		size = entradasB.getPreferredSize();
//		entradasB.setBounds(25 + insets.left, 300 + insets.top, size.width, size.height);
		
		size = tituloSwitchA.getPreferredSize();
		tituloSwitchA.setBounds(25 + insets.left, 160 + insets.top, size.width, size.height);
		size = tituloSwitchB.getPreferredSize();
		tituloSwitchB.setBounds(25 + insets.left, 280 + insets.top, size.width, size.height);
		
//		size = lampadaA.getPreferredSize();
//		lampadaA.setBounds((frameWidth - size.width * 2) + insets.left, (frameHeight / 2 - size.height * 2) + insets.top, size.width, size.height);
		size = saidaA.getPreferredSize();
		saidaA.setBounds((frameWidth - size.width * 2) + insets.left, (frameHeight / 2 - size.height * 2) + insets.top, size.width, size.height);
		
		
		size = switchA.getPreferredSize();
		switchA.setBounds(150 + insets.left, 170 + insets.top, size.width, size.height);
		size = switchB.getPreferredSize();	
		switchB.setBounds(150 + insets.left, 290 + insets.top, size.width, size.height);
		
        frame.setLocationRelativeTo(null); // Agora a janela abre sempre no meio da tela do computadodo usuário, acredito que este tipo de feature fará com que o usuário respeite mais o meu poder de manipular o que aparece ou deixa de aparecer na máquina dele obrigado
        frame.setVisible(true);
		frame.add(panel);
	}

	private void criaPainel() {
		panel.removeAll();
		// Adiciona o que criamos no painel
		panel.add(buttonConfirmarPorta);
		panel.add(buttonSelecionar);
		panel.add(frameTitle);
		panel.add(comboBox);
		
		frame = new JFrame("Simulador de Portas Lógicas");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Insets insets = frame.getInsets();
		frame.setSize(frameWidth + insets.left + insets.right, frameHeight + insets.top + insets.bottom);
		
		
		// Define a posição do que criamos no painel (poderiamos usar para alterar o tamanho, mas isso "distorceria
		// os icones e textos
		Dimension size = comboBox.getPreferredSize();
		comboBox.setBounds((frameWidth / 2 - size.width - 8) + insets.left, 50 + insets.top, size.width, size.height);
		
		size = buttonConfirmarPorta.getPreferredSize();
		buttonConfirmarPorta.setBounds((frameWidth / 2 + 5) + insets.left, 49 + insets.top, size.width, size.height);
		
		size = frameTitle.getPreferredSize();
		frameTitle.setBounds((300 - size.width / 2) + insets.left, insets.top, size.width, size.height);
		
		size = buttonSelecionar.getPreferredSize();
		buttonSelecionar.setBounds(20 + insets.left, (frameHeight - size.height * 3) + insets.top, size.width, size.height);
		
		if(this.doorStyle == 0) {
			// Portas básicas e Xor
//			panel.add(entradasA);
//			panel.add(entradasB);
			panel.add(tituloSwitchA);
			panel.add(tituloSwitchB);
			panel.add(switchA);
			panel.add(switchB);
//			panel.add(lampadaA);
			panel.add(checkBoxA);
			panel.add(checkBoxB);
			panel.add(saidaA);
			
			size = checkBoxA.getPreferredSize();
			checkBoxA.setBounds(25 + insets.left, 180 + insets.top, size.width, size.height);
			size = checkBoxB.getPreferredSize();
			checkBoxB.setBounds(25 + insets.left, 300 + insets.top, size.width, size.height);
			
//			size = entradasA.getPreferredSize();
//			entradasA.setBounds(25 + insets.left, 180 + insets.top, size.width, size.height);
//			size = entradasB.getPreferredSize();
//			entradasB.setBounds(25 + insets.left, 300 + insets.top, size.width, size.height);
			
			size = tituloSwitchA.getPreferredSize();
			tituloSwitchA.setBounds(25 + insets.left, 160 + insets.top, size.width, size.height);
			size = tituloSwitchB.getPreferredSize();
			tituloSwitchB.setBounds(25 + insets.left, 280 + insets.top, size.width, size.height);
			
			size = saidaA.getPreferredSize();
			saidaA.setBounds((frameWidth - size.width * 2) + insets.left, (frameHeight / 2 - size.height * 2) + insets.top, size.width, size.height);
			
			size = switchA.getPreferredSize();
			switchA.setBounds(150 + insets.left, 170 + insets.top, size.width, size.height);
			size = switchB.getPreferredSize();
			switchB.setBounds(150 + insets.left, 290 + insets.top, size.width, size.height);
			
		} else if(this.doorStyle == 1) {
			// Not
//			panel.add(entradasA);
			panel.add(tituloSwitchA);
			panel.add(switchA);
//			panel.add(lampadaA);
			panel.add(checkBoxA);
			panel.add(saidaA);
				
			size = checkBoxA.getPreferredSize();
			checkBoxA.setBounds(25 + insets.left, 200 + insets.top, size.width, size.height);
			
			size = tituloSwitchA.getPreferredSize();
			tituloSwitchA.setBounds(25 + insets.left, 180 + insets.top, size.width, size.height);
			
			size = saidaA.getPreferredSize();
			saidaA.setBounds((frameWidth - size.width * 2) + insets.left, (frameHeight / 2 - size.height * 2) + insets.top, size.width, size.height);
			
			size = switchA.getPreferredSize();
			switchA.setBounds(150 + insets.left, 190 + insets.top, size.width, size.height);
			
		} else if(this.doorStyle == 2) {
			// HalfAdder
//			panel.add(entradasA);
//			panel.add(entradasB);
			panel.add(tituloSwitchA);
			panel.add(tituloSwitchB);
			panel.add(switchA);
			panel.add(switchB);
//			panel.add(lampadaA);
//			panel.add(lampadaB);
			panel.add(checkBoxA);
			panel.add(checkBoxB);
			panel.add(saidaA);
			panel.add(saidaB);
			
			size = checkBoxA.getPreferredSize();
			checkBoxA.setBounds(25 + insets.left, 180 + insets.top, size.width, size.height);
			size = checkBoxB.getPreferredSize();
			checkBoxB.setBounds(25 + insets.left, 300 + insets.top, size.width, size.height);
			
//			size = entradasA.getPreferredSize();
//			entradasA.setBounds(25 + insets.left, 180 + insets.top, size.width, size.height);
//			size = entradasB.getPreferredSize();
//			entradasB.setBounds(25 + insets.left, 300 + insets.top, size.width, size.height);
			
			size = tituloSwitchA.getPreferredSize();
			tituloSwitchA.setBounds(25 + insets.left, 160 + insets.top, size.width, size.height);
			size = tituloSwitchB.getPreferredSize();
			tituloSwitchB.setBounds(25 + insets.left, 280 + insets.top, size.width, size.height);
			
			size = saidaA.getPreferredSize();
			saidaA.setBounds((frameWidth - size.width * 2) + insets.left, (frameHeight / 2 - size.height * 2) + insets.top, size.width, size.height);
			size = saidaB.getPreferredSize();
			saidaB.setBounds((frameWidth - size.width * 2) + insets.left, 280 + insets.top, size.width, size.height);
			
			size = switchA.getPreferredSize();
			switchA.setBounds(150 + insets.left, 170 + insets.top, size.width, size.height);
			size = switchB.getPreferredSize();
			switchB.setBounds(150 + insets.left, 290 + insets.top, size.width, size.height);
			
		} else if(doorStyle == 3) {
			// FullAdder
//			panel.add(entradasA);
//			panel.add(entradasB);
//			panel.add(entradasC);
			panel.add(tituloSwitchA);
			panel.add(tituloSwitchB);
			panel.add(tituloSwitchC);
			panel.add(switchA);
			panel.add(switchB);
			panel.add(switchC);
//			panel.add(lampadaA);
//			panel.add(lampadaB);
			panel.add(checkBoxA);
			panel.add(checkBoxB);
			panel.add(checkBoxC);
			panel.add(saidaA);
			panel.add(saidaB);
			
			
			size = saidaA.getPreferredSize();
			saidaA.setBounds((frameWidth - size.width * 2) + insets.left, (frameHeight / 2 - size.height * 2) + insets.top, size.width, size.height);
			size = saidaB.getPreferredSize();
			saidaB.setBounds((frameWidth - size.width * 2) + insets.left, 280 + insets.top, size.width, size.height);
			
			size = checkBoxA.getPreferredSize();
			checkBoxA.setBounds(25 + insets.left, 140 + insets.top, size.width, size.height);
			size = checkBoxB.getPreferredSize();
			checkBoxB.setBounds(25 + insets.left, 220 + insets.top, size.width, size.height);
			size = checkBoxC.getPreferredSize();
			checkBoxC.setBounds(25 + insets.left, 330 + insets.top, size.width, size.height);
			
//			size = entradasA.getPreferredSize();
//			entradasA.setBounds(25 + insets.left, 140 + insets.top, size.width, size.height);
//			size = entradasB.getPreferredSize();
//			entradasB.setBounds(25 + insets.left, 220 + insets.top, size.width, size.height);
//			size = entradasC.getPreferredSize();
//			entradasC.setBounds(25 + insets.left, 300 + insets.top, size.width, size.height);
			
			size = tituloSwitchA.getPreferredSize();
			tituloSwitchA.setBounds(25 + insets.left, 120 + insets.top, size.width, size.height);
			size = tituloSwitchB.getPreferredSize();
			tituloSwitchB.setBounds(25 + insets.left, 200 + insets.top, size.width, size.height);
			size = tituloSwitchC.getPreferredSize();
			tituloSwitchC.setBounds(25 + insets.left, 280 + insets.top, size.width, size.height);
			
			size = saidaA.getPreferredSize();
			saidaA.setBounds((frameWidth - size.width * 2) + insets.left, (frameHeight / 2 - size.height * 2) + insets.top, size.width, size.height);
			size = saidaB.getPreferredSize();
			saidaB.setBounds((frameWidth - size.width * 2) + insets.left, 280 + insets.top, size.width, size.height);
			
			size = switchA.getPreferredSize();
			switchA.setBounds(150 + insets.left, 130 + insets.top, size.width, size.height);
			size = switchB.getPreferredSize();
			switchB.setBounds(150 + insets.left, 210 + insets.top, size.width, size.height);
			size = switchC.getPreferredSize();
			switchC.setBounds(150 + insets.left, 290 + insets.top, size.width, size.height);
		
		}
		
		panel.updateUI();
	}

	
	private void defineLogica() {
		if(this.doorStyle == 3) {
			// FullAdder
			if(checkBoxA.isSelected()) {
				switchValueA = true;
				currentSwitchStateA = switchOnA;
				
				
			} else {
				currentSwitchStateA = switchOffA;
				switchValueA = false;
	
			}
		    
		    if(checkBoxB.isSelected()) {
				currentSwitchStateB = switchOnB;
				switchValueB = true; 
				
			} else {
				currentSwitchStateB = switchOffB;
				switchValueB = false;
				
			}
		    
		    if(checkBoxC.isSelected()) {
		    	currentSwitchStateC = switchOnC;
		    	switchValueC = true;
		    
		    } else {
		    	currentSwitchStateC = switchOffC;
		    	switchValueC = false;
		    	
		    }
		    
		    inA.setOutputValue(switchValueA);
			pinA.setSource(inA);
			
			inB.setOutputValue(switchValueB);
			pinB.setSource(inB);
			
			inC.setOutputValue(switchValueC);
			pinC.setSource(inC);
			
			currentGate = objetoDasPortas[comboBox.getSelectedIndex()];
		    currentGate.setPinA(pinA);
		    currentGate.setPinB(pinB);
		    currentGate.setPinC(pinC);
		    
		    pinLampA.setIndex(0);
		    pinLampA.setSource(currentGate);
		    pinLampB.setIndex(1);
		    pinLampB.setSource(currentGate);
		    
		    lampA.setInputPin(pinLampA);
		    lampB.setInputPin(pinLampB);
		    
		    saidaA.setSelected(lampA.isOn());
		    saidaB.setSelected(lampB.isOn());
		    
//		    if(currentGate.getOutputValue(0)) {
//		    	currentImage = lampadaOn;
//		    
//		    } else {
//		    	currentImage = lampadaOff;
//		    
//		    }
//		    
//		    if(currentGate.getOutputValue(1)) {
//		    	currentImageB = lampadaOn;
//		    	
//		    } else {
//		    	currentImageB = lampadaOff;
//		    	
//		    }
//		    
//		    lampadaA.setIcon(new ImageIcon(currentImage));
//		    lampadaB.setIcon(new ImageIcon(currentImageB));
			switchA.setIcon(new ImageIcon(currentSwitchStateA));
			switchB.setIcon(new ImageIcon(currentSwitchStateB));
			switchC.setIcon(new ImageIcon(currentSwitchStateC));
			
		} else if(this.doorStyle == 2) {
			// HalfAdder
			if(checkBoxA.isSelected()) {
				switchValueA = true;
				currentSwitchStateA = switchOnA;
				
				
			} else {
				currentSwitchStateA = switchOffA;
				switchValueA = false;
	
			}
		    
		    if(checkBoxB.isSelected()) {
				currentSwitchStateB = switchOnB;
				switchValueB = true; 
				
			} else {
				currentSwitchStateB = switchOffB;
				switchValueB = false;
				
			}
		    
		    inA.setOutputValue(switchValueA);
			pinA.setSource(inA);
			
			inB.setOutputValue(switchValueB);
			pinB.setSource(inB);
			
			currentGate = objetoDasPortas[comboBox.getSelectedIndex()];
		    currentGate.setPinA(pinA);
		    currentGate.setPinB(pinB);
	
		    pinLampA.setIndex(0);
		    pinLampA.setSource(currentGate);
		    pinLampB.setIndex(1);
		    pinLampB.setSource(currentGate);
		    
		    lampA.setInputPin(pinLampA);
		    lampB.setInputPin(pinLampB);
		    
		    saidaA.setSelected(lampA.isOn());
		    saidaB.setSelected(lampB.isOn());
		    
//		    if(currentGate.getOutputValue(0)) {
//		    	currentImage = lampadaOn;
//		    
//		    } else {
//		    	currentImage = lampadaOff;
//		    
//		    }
//		    
//		    if(currentGate.getOutputValue(1)) {
//		    	currentImageB = lampadaOn;
//		    	
//		    } else {
//		    	currentImageB = lampadaOff;
//		    	
//		    }
//		    
//		    lampadaA.setIcon(new ImageIcon(currentImage));
//		    lampadaB.setIcon(new ImageIcon(currentImageB));
			switchA.setIcon(new ImageIcon(currentSwitchStateA));
			switchB.setIcon(new ImageIcon(currentSwitchStateB));
			
		} else if(this.doorStyle == 0) {
			// AND, OR e XOR
			if(checkBoxA.isSelected()) {
				switchValueA = true;
				currentSwitchStateA = switchOnA;
				
				
			} else {
				currentSwitchStateA = switchOffA;
				switchValueA = false;
	
			}
		    
		    if(checkBoxB.isSelected()) {
				currentSwitchStateB = switchOnB;
				switchValueB = true; 
				
			} else {
				currentSwitchStateB = switchOffB;
				switchValueB = false;
				
			}
		    
		    inA.setOutputValue(switchValueA);
			pinA.setSource(inA);
			
			inB.setOutputValue(switchValueB);
			pinB.setSource(inB);

			currentGate = objetoDasPortas[comboBox.getSelectedIndex()];
		    currentGate.setPinA(pinA);
		    currentGate.setPinB(pinB);
		    
		    pinLampA.setSource(currentGate);
		    
		    lampA.setInputPin(pinLampA);
		    
		    saidaA.setSelected(lampA.isOn());
		    
//		    if(currentGate.getOutputValue(0)) {
//		    	currentImage = lampadaOn;
//		    
//		    } else {
//		    	currentImage = lampadaOff;
//		    
//		    }
//		    
//		    lampadaA.setIcon(new ImageIcon(currentImage));
			switchA.setIcon(new ImageIcon(currentSwitchStateA));
			switchB.setIcon(new ImageIcon(currentSwitchStateB));
			
		} else if(this.doorStyle == 1) {
			// NOT
			if(checkBoxA.isSelected()) {
				switchValueA = true;
				currentSwitchStateA = switchOnA;
				
			} else {
				currentSwitchStateA = switchOffA;
				switchValueA = false;

			}	
		    inA.setOutputValue(switchValueA);
			pinA.setSource(inA);
			
			currentGate = objetoDasPortas[comboBox.getSelectedIndex()];
		    currentGate.setPinA(pinA);
		    
		    pinLampA.setIndex(0);
		    pinLampA.setSource(currentGate);

		    lampA.setInputPin(pinLampA);
		    
		    saidaA.setSelected(lampA.isOn());

//		    if(currentGate.getOutputValue(0)) {
//		    	currentImage = lampadaOn;
//		    
//		    } else {
//		    	currentImage = lampadaOff;
//		    
//		    }
//		    lampadaA.setIcon(new ImageIcon(currentImage));
			switchA.setIcon(new ImageIcon(currentSwitchStateA));
		
		}
		
		panel.repaint();

    	panel.getToolkit().sync();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
	
}