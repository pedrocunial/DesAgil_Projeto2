package desagil.vision;

import java.awt.Color;
import java.awt.Graphics;


public class DesenhaOr extends DesenhaPortas{
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g){
		super.paintComponent(g);
	
		g.setColor(Color.GREEN);
		g.drawLine(400,100,431,100);
		g.drawLine(400,125,431,125);
		g.drawArc(402, 95, 35, 35, 90, -180);
		//g.drawLine(425,95,425,130);
		g.drawLine(425,95,450,95);
		g.drawLine(425,130,450,130);
		g.drawArc(425, 95, 50, 35, 90, -90);
		g.drawArc(425, 95, 50, 35, 270, 90);
		g.drawLine(475,112,500,112);

	}
}
