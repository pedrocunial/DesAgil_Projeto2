package desagil.model;

public class Lamp implements Drain {
	private InputPin input;
	
	public InputPin getInputPin(int index) {
		return input;
	}
	
	public void setInputPin(InputPin input) {
		this.input = input;
	}

	public boolean isOn(int index) {
		return input.getSource().getOutputValue(index);
	}
	
}
