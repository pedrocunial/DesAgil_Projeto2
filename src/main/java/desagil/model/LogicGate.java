package desagil.model;

abstract class LogicGate implements Source, Drain {
	private boolean outputValue;
	private InputPin input;	
	
	public boolean getOutputValue(int index) {
		return outputValue;
	}	

	public InputPin getInputPin(int index) {
		return input;
		
	}
	
}
