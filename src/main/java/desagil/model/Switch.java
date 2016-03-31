package desagil.model;

public class Switch implements Source {
	private boolean outputValue;
	
	public boolean getOutputValue(int index) {
		if(index == 1) {
			outputValue = true;
		
		} else if(index == 0) {
			outputValue = false;
			
		}
		return outputValue;
	}

	public void setOutputValue(boolean outputValue) {
		this.outputValue = outputValue;
	}

}
