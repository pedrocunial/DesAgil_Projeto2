package desagil.model;

public class HalfAdder extends LogicGate {
	private InputPin pinA;
	private InputPin pinB;
	int index;
	
	public void setPinA(InputPin pinA) {
		this.pinA = pinA;
	}
	
	public void setPinB(InputPin pinB) {
		this.pinB = pinB;
	}
	

	@Override
	public boolean getOutputValue(int index) {
		this.index = index;
		boolean[] resposta = new boolean[2];		
		
		XorGate xor = new XorGate();
		xor.setPinA(pinA);
		xor.setPinB(pinB);
		resposta[0] = xor.getOutputValue(0);
	
		AndGate and = new AndGate();
		and.setPinA(pinA);
		and.setPinB(pinB);
		resposta[1] = and.getOutputValue(0);
			
		return resposta[index];
	}


}
