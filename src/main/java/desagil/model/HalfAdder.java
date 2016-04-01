package desagil.model;

public class HalfAdder extends LogicGate {
	private InputPin pinA;
	private InputPin pinB;
	int index;
	
	public InputPin getPinA() {
		return pinA;
	}
	public InputPin getPinB() {
		return pinB;
	}
	public void setPinA(InputPin pinA) {
		this.pinA = pinA;
	}
	public void setPinB(InputPin pinB) {
		this.pinB = pinB;
	}
	
	
	
	@Override
	public boolean getOutputValue(int index) {
		this.index = index;
		boolean resposta;		
		
		if(index == 0) {
			XorGate xor = new XorGate();
			xor.setPinA(pinA);
			xor.setPinB(pinB);
			resposta = xor.getOutputValue(0);
		
		} else {
			AndGate and = new AndGate();
			and.setPinA(pinA);
			and.setPinB(pinB);
			resposta = and.getOutputValue(0);
			
		}
		
		return resposta;
	}
}
