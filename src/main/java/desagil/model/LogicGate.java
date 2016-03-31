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
	
	public InputPin getOutputPin(int index) {
		boolean sinal = getOutputValue(0);
		InputPin outputPin = new InputPin();
		Switch s = new Switch();
		
		s.setOutputValue(sinal);
		outputPin.setSource(s);
		return outputPin;
	}
	
}
