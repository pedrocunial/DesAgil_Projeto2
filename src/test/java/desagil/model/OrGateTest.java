package desagil.model;

import org.junit.Assert;
import org.junit.Test;

public class OrGateTest {

	@Test
	public void comEntradaTrueTrue() {
		OrGate or = new OrGate();
		Switch inA = new Switch();
		Switch inB = new Switch();
		
		inA.setOutputValue(true);
		inB.setOutputValue(true);
		InputPin pinA = new InputPin();
		InputPin pinB = new InputPin();
		pinA.setSource(inA);
		pinB.setSource(inB);
		
		or.setPinA(pinA);
		or.setPinB(pinB);
			
		Assert.assertTrue(or.getOutputValue(0));
		
	}
	
	@Test
	public void comEntradaTrueFalse() {
		OrGate or = new OrGate();
		Switch inA = new Switch();
		Switch inB = new Switch();
		
		inA.setOutputValue(true);
		inB.setOutputValue(false);
		InputPin pinA = new InputPin();
		InputPin pinB = new InputPin();
		pinA.setSource(inA);
		pinB.setSource(inB);
		
		or.setPinA(pinA);
		or.setPinB(pinB);
			
		Assert.assertTrue(or.getOutputValue(0));
		
	}
	
	@Test
	public void comEntradaFalseTrue() {
		OrGate or = new OrGate();
		Switch inA = new Switch();
		Switch inB = new Switch();
		
		inA.setOutputValue(false);
		inB.setOutputValue(true);
		InputPin pinA = new InputPin();
		InputPin pinB = new InputPin();
		pinA.setSource(inA);
		pinB.setSource(inB);
		
		or.setPinA(pinA);
		or.setPinB(pinB);
			
		Assert.assertTrue(or.getOutputValue(0));
		
	}
	
	@Test
	public void comEntradaFalseFalse() {
		OrGate or = new OrGate();
		Switch inA = new Switch();
		Switch inB = new Switch();
		
		inA.setOutputValue(false);
		inB.setOutputValue(false);
		InputPin pinA = new InputPin();
		InputPin pinB = new InputPin();
		pinA.setSource(inA);
		pinB.setSource(inB);
		
		or.setPinA(pinA);
		or.setPinB(pinB);
			
		Assert.assertFalse(or.getOutputValue(0));
		
	}
}
