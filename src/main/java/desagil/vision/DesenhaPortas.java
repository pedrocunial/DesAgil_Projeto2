package desagil.vision;


import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;


public class DesenhaPortas extends JComponent {
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.GREEN);
		g.drawRect(380,90,20,20);
		g.drawRect(380,115,20,20);
		g.drawArc(500,102, 20, 20, 0, 360);
		
	}

}