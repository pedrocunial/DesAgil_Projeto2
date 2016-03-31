package desagil.model;

abstract class LogicGate implements Source, Drain {
	private boolean outputValue;
	private InputPin input;	
	
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
