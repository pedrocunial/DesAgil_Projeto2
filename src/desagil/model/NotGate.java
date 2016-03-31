package desagil.model;

public class NotGate extends LogicGate {
	private InputPin pinA;
	
	@Override
	public boolean getOutputValue(int index) {
		boolean sinalA = pinA.getSource().getOutputValue(pinA.getIndex());
		return !sinalA;
	}


}
