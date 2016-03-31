package desagil.model;

public class FullAdder extends LogicGate{
	InputPin pinA;
	InputPin pinB;
	InputPin pinC;
	int index;
	
	public InputPin getPinA() {
		return pinA;
	}
	public void setPinA(InputPin pinA) {
		this.pinA = pinA;
	}
	public InputPin getPinB() {
		return pinB;
	}
	public void setPinB(InputPin pinB) {
		this.pinB = pinB;
	}
	public InputPin getPinC() {
		return pinC;
	}
	public void setPinC(InputPin pinC) {
		this.pinC = pinC;
	}
	
	@Override
	public boolean getOutputValue(int index) {
		this.index = index;
		HalfAdder halfA = new HalfAdder();
		HalfAdder halfB = new HalfAdder();
		OrGate or = new OrGate();
		boolean resposta;
		
		halfA.setPinA(pinA);
		halfA.setPinB(pinB);
		
		InputPin sumA = new InputPin();
		InputPin carryA = new InputPin();
		
		sumA = halfA.getOutputPin(0);
		halfB.setPinA(sumA);
		halfB.setPinB(pinC);
				
		if(index == 0) {
			resposta = halfB.getOutputValue(0);
			
		} else {
			InputPin carryB = new InputPin();
			carryB = halfB.getOutputPin(1);
			carryA = halfA.getOutputPin(1);
			or.setPinA(carryA);
			or.setPinB(carryB);
			resposta = or.getOutputValue(0);
			
		}
		return resposta;
	
	}
	
	@Override
	public InputPin getOutputPin(int index) {
		this.index = index;
		InputPin outputPin = new InputPin();

		if(index == 0) {
			boolean sinal = getOutputValue(0);
			Switch s = new Switch();
			
			s.setOutputValue(sinal);
			outputPin.setSource(s);
		
		} else {
			boolean sinal = getOutputValue(1);
			Switch s = new Switch();
			
			s.setOutputValue(sinal);
			outputPin.setSource(s);
			
		}		
		return outputPin;
		
	}
	

}
