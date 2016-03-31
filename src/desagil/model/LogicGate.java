package desagil.model;

public class LogicGate implements Source, Drain {
	boolean outputValue;
	InputPin input;	
	
	public boolean getOutputValue(int index) {
		if(index == 1) {
			outputValue = true;
		
		} else if(index == 0) {
			outputValue = false;
			
		}
		return outputValue;
	}	

	public InputPin getInputPin(int index) {
		return input;
		
	}
	
}
