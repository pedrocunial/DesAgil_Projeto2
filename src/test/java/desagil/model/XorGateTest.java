package desagil.model;

import org.junit.Assert;
import org.junit.Test;

public class XorGateTest {
	
	@Test
	public void comEntradaTrueTrue() {
		XorGate xor = new XorGate();
		Switch inA = new Switch();
		Switch inB = new Switch();
		
		inA.setOutputValue(true);
		inB.setOutputValue(true);
		InputPin pinA = new InputPin();
		InputPin pinB = new InputPin();
		pinA.setSource(inA);
		pinB.setSource(inB);
		pinA.setIndex(0); // Não tem utilidade por enquanto, mas vamos dar nome aos fios
		pinB.setIndex(1);
		
		xor.setPinA(pinA);
		xor.setPinB(pinB);
			
		Assert.assertFalse(xor.getOutputValue(0));
		
	}
	
	@Test
	public void comEntradaTrueFalse() {
		XorGate xor = new XorGate();
		Switch inA = new Switch();
		Switch inB = new Switch();
		
		inA.setOutputValue(true);
		inB.setOutputValue(false);
		InputPin pinA = new InputPin();
		InputPin pinB = new InputPin();
		pinA.setSource(inA);
		pinB.setSource(inB);
		pinA.setIndex(0);
		pinB.setIndex(1);
		
		xor.setPinA(pinA);
		xor.setPinB(pinB);
			
		Assert.assertTrue(xor.getOutputValue(0));
		
	}
	
	@Test
	public void comEntradaFalseTrue() {
		XorGate xor = new XorGate();
		Switch inA = new Switch();
		Switch inB = new Switch();
		
		inA.setOutputValue(false);
		inB.setOutputValue(true);
		InputPin pinA = new InputPin();
		InputPin pinB = new InputPin();
		pinA.setSource(inA);
		pinB.setSource(inB);
		pinA.setIndex(0);
		pinB.setIndex(1);
		
		xor.setPinA(pinA);
		xor.setPinB(pinB);
			
		Assert.assertTrue(xor.getOutputValue(0));
		
	}
	
	@Test
	public void comEntradaFalseFalse() {
		XorGate xor = new XorGate();
		Switch inA = new Switch();
		Switch inB = new Switch();
		
		inA.setOutputValue(false);
		inB.setOutputValue(false);
		InputPin pinA = new InputPin();
		InputPin pinB = new InputPin();
		pinA.setSource(inA);
		pinB.setSource(inB);
		pinA.setIndex(0);
		pinB.setIndex(1);
		
		xor.setPinA(pinA);
		xor.setPinB(pinB);
			
		Assert.assertFalse(xor.getOutputValue(0));
		
	}
}
