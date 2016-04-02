package desagil.control;

import javax.swing.SwingUtilities;

import desagil.vision.Screen;


public class Main {
	
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
}
