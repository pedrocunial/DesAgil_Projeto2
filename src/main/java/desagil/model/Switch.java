package desagil.model;

public class Switch implements Source {
	private boolean outputValue;
	
	public boolean getOutputValue(int index) {
		return outputValue;
	}
	
	public void setOutputValue(boolean value) {
		this.outputValue = value;
	}

}
