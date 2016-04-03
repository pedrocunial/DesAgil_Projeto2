package desagil.model;

public abstract class LogicGate implements Source, Drain {
	private boolean outputValue;
	private InputPin pinA, pinB, pinC;
	
	
	public void setPinA(InputPin pinA) {
		this.pinA = pinA;
	}

	public void setPinB(InputPin pinB) {
		this.pinB = pinB;
	}

	public void setPinC(InputPin pinC) {
		this.pinC = pinC;
	}

	public boolean getOutputValue(int index) {
		return outputValue;
	}	

	public InputPin getInputPin(int index) {
		if(index == 0) {
			return pinA;
		} else if(index == 1) {
			return pinB;
		} else {
			return pinC;
		}
	}
	
	
	
	
}
