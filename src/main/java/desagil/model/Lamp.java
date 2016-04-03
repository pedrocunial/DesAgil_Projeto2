package desagil.model;

public class Lamp implements Drain {
	private InputPin input;
	
	public InputPin getInputPin(int index) {
		return input;
	}
	
	public void setInputPin(InputPin input) {
		this.input = input;
	}

	public boolean getLampValue() {
		return input.getSource().getOutputValue(0);
	}
	
}
