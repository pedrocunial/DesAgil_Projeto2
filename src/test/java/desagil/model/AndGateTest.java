package desagil.model;

import org.junit.Assert;
import org.junit.Test;


public class AndGateTest {
	
	@Test
	public void comEntradaTrueTrue() {
		AndGate and = new AndGate();
		Switch inA = new Switch();
		Switch inB = new Switch();
		
		inA.setOutputValue(true);
		inB.setOutputValue(true);
		InputPin pinA = new InputPin();
		InputPin pinB = new InputPin();
		pinA.setSource(inA);
		pinB.setSource(inB);

		and.setPinA(pinA);
		and.setPinB(pinB);
			
		Assert.assertTrue(and.getOutputValue(0));
		
	}
	
	@Test
	public void comEntradaTrueFalse() {
		AndGate and = new AndGate();
		Switch inA = new Switch();
		Switch inB = new Switch();
		
		inA.setOutputValue(true);
		inB.setOutputValue(false);
		InputPin pinA = new InputPin();
		InputPin pinB = new InputPin();
		pinA.setSource(inA);
		pinB.setSource(inB);
		
		and.setPinA(pinA);
		and.setPinB(pinB);
			
		Assert.assertFalse(and.getOutputValue(0));
		
	}
	
	@Test
	public void comEntradaFalseTrue() {
		AndGate and = new AndGate();
		Switch inA = new Switch();
		Switch inB = new Switch();
		
		inA.setOutputValue(false);
		inB.setOutputValue(true);
		InputPin pinA = new InputPin();
		InputPin pinB = new InputPin();
		pinA.setSource(inA);
		pinB.setSource(inB);
		
		and.setPinA(pinA);
		and.setPinB(pinB);
			
		Assert.assertFalse(and.getOutputValue(0));
		
	}
	
	@Test
	public void comEntradaFalseFalse() {
		AndGate and = new AndGate();
		Switch inA = new Switch();
		Switch inB = new Switch();
		
		inA.setOutputValue(false);
		inB.setOutputValue(false);
		InputPin pinA = new InputPin();
		InputPin pinB = new InputPin();
		pinA.setSource(inA);
		pinB.setSource(inB);
		
		and.setPinA(pinA);
		and.setPinB(pinB);
			
		Assert.assertFalse(and.getOutputValue(0));
		
	}
}
