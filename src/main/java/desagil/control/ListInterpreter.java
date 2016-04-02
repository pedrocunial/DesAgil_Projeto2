package desagil.control;

import desagil.model.*;
import desagil.vision.*;

public class ListInterpreter {
	private Object[] objetoDasPortas = new Object[6];
	private String[] nomeDasPortas = new String[6];
	
	public ListInterpreter() {
		nomeDasPortas = Screen.getPortas(); // {"AND", "OR", "NOT", "XOR", "HalfAdder", "FullAdder"}
		
		objetoDasPortas[0] = new AndGate();
		objetoDasPortas[1] = new OrGate();
		objetoDasPortas[2] = new NotGate();
		objetoDasPortas[3] = new XorGate();
		objetoDasPortas[4] = new HalfAdder();
		objetoDasPortas[5] = new FullAdder();
	
	}
	
}
