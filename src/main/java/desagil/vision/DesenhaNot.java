package desagil.vision;

import java.awt.Color;
import java.awt.Graphics;

public class DesenhaNot extends DesenhaPortas{
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	
		g.setColor(Color.GREEN);
		g.drawLine(400,100,425,100);
		g.drawLine(400,125,425,125);
		g.drawLine(425,95,425,130);
		g.drawLine(425,95,470,112);
		g.drawLine(425,130,470,112);
		g.drawLine(477,112,500,112);
		g.drawArc(471,109, 6, 6, 0, 360);
	
	}
}
