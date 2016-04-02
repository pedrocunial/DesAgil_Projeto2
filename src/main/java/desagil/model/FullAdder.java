package desagil.model;

public class FullAdder extends LogicGate{
	InputPin pinA;
	InputPin pinB;
	InputPin pinC;
	int index;
	
	public void setPinA(InputPin pinA) {
		this.pinA = pinA;
	}

	public void setPinB(InputPin pinB) {
		this.pinB = pinB;
	}
	
	public void setPinC(InputPin pinC) {
		this.pinC = pinC;
	}
	
	@Override
	public boolean getOutputValue(int index) {
		this.index = index;
		boolean[] resposta = new boolean[2];
		HalfAdder halfA = new HalfAdder();
		HalfAdder halfB = new HalfAdder();
		OrGate or = new OrGate();
		
		halfA.setPinA(pinA);
		halfA.setPinB(pinB);
		
		InputPin sumA = new InputPin();
		InputPin carryA = new InputPin();
		sumA.setIndex(0);
		carryA.setIndex(1);
		
		
		// Posso 'tapar esse buraco' usando as portas Xor, mas isso não resolveria o problema
		
		sumA.setSource(halfA); // Saida 0
		halfB.setPinA(sumA);
		halfB.setPinB(pinC);
		
		resposta[0] = halfB.getOutputValue(0);
		
		InputPin carryB = new InputPin();
		carryB.setIndex(1);
		carryB.setSource(halfB); // Saida 1
		carryA.setSource(halfA); // Saida 1
		or.setPinA(carryA);
		or.setPinB(carryB);
		resposta[1] = or.getOutputValue(0);
		
		return resposta[index];
	}

}
