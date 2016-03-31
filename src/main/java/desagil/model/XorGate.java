package desagil.model;

public class XorGate extends LogicGate {
	private InputPin pinA;
	private InputPin pinB;
	
	public void setPinA(InputPin pinA) {
		this.pinA = pinA;
	}
	public void setPinB(InputPin pinB) {
		this.pinB = pinB;
	}
	
	@Override
	public boolean getOutputValue(int index) {
		AndGate andA = new AndGate();
		AndGate andB = new AndGate();
		NotGate notA = new NotGate();
		NotGate notB = new NotGate();
		
		// Fazendo a lógica da porta Xor com as que eu já feitas
		notA.setPinA(pinA);
		notB.setPinA(pinB);
		
		InputPin pinC = new InputPin();
		InputPin pinD = new InputPin();
		
		pinC = notA.getOutputPin(0);
		pinD = notB.getOutputPin(0);
				
		andA.setPinA(pinC);
		andA.setPinB(pinB);
		andB.setPinA(pinA);
		andB.setPinB(pinD);
		
		InputPin pinE = new InputPin();
		InputPin pinF = new InputPin();
		
		pinE = andA.getOutputPin(0);
		pinF = andB.getOutputPin(0);
				
		OrGate or = new OrGate();
		or.setPinA(pinE);
		or.setPinB(pinF);
		
		boolean sinalFinal = or.getOutputValue(0);
		return sinalFinal;
		
	}

}
