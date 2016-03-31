package desagil.model;

import org.junit.Assert;
import org.junit.Test;

public class FullAdderTest {
	
	@Test
	public void comEntradaTrueTrueTrue() {
		FullAdder full = new FullAdder();
		Switch inA = new Switch();
		Switch inB = new Switch();
		Switch inC = new Switch();
		
		inA.setOutputValue(true);
		inB.setOutputValue(true);
		inC.setOutputValue(true);
		InputPin pinA = new InputPin();
		InputPin pinB = new InputPin();
		InputPin pinC = new InputPin();
		pinA.setSource(inA);
		pinB.setSource(inB);
		pinC.setSource(inC);
		
		full.setPinA(pinA);
		full.setPinB(pinB);
		full.setPinC(pinC);
				
		
		Assert.assertTrue(full.getOutputValue(0));
		Assert.assertTrue(full.getOutputValue(1));
		
	}
	
	@Test
	public void comEntradaTrueTrueFalse() {
		FullAdder full = new FullAdder();
		Switch inA = new Switch();
		Switch inB = new Switch();
		Switch inC = new Switch();
		
		inA.setOutputValue(true);
		inB.setOutputValue(true);
		inC.setOutputValue(false);
		InputPin pinA = new InputPin();
		InputPin pinB = new InputPin();
		InputPin pinC = new InputPin();
		pinA.setSource(inA);
		pinB.setSource(inB);
		pinC.setSource(inC);
		
		full.setPinA(pinA);
		full.setPinB(pinB);
		full.setPinC(pinC);
				
		
		Assert.assertFalse(full.getOutputValue(0));
		Assert.assertTrue(full.getOutputValue(1));
		
	}
	
	@Test
	public void comEntradaTrueFalseTrue() {
		FullAdder full = new FullAdder();
		Switch inA = new Switch();
		Switch inB = new Switch();
		Switch inC = new Switch();
		
		inA.setOutputValue(true);
		inB.setOutputValue(false);
		inC.setOutputValue(true);
		InputPin pinA = new InputPin();
		InputPin pinB = new InputPin();
		InputPin pinC = new InputPin();
		pinA.setSource(inA);
		pinB.setSource(inB);
		pinC.setSource(inC);
		
		full.setPinA(pinA);
		full.setPinB(pinB);
		full.setPinC(pinC);
				
		
		Assert.assertFalse(full.getOutputValue(0));
		Assert.assertTrue(full.getOutputValue(1));
		
	}
	
	@Test
	public void comEntradaFalseTrueTrue() {
		FullAdder full = new FullAdder();
		Switch inA = new Switch();
		Switch inB = new Switch();
		Switch inC = new Switch();
		
		inA.setOutputValue(false);
		inB.setOutputValue(true);
		inC.setOutputValue(true);
		InputPin pinA = new InputPin();
		InputPin pinB = new InputPin();
		InputPin pinC = new InputPin();
		pinA.setSource(inA);
		pinB.setSource(inB);
		pinC.setSource(inC);
		
		full.setPinA(pinA);
		full.setPinB(pinB);
		full.setPinC(pinC);
				
		
		Assert.assertFalse(full.getOutputValue(0));
		Assert.assertTrue(full.getOutputValue(1));
		
	}
	
	@Test
	public void comEntradaTrueFalseFalse() {
		FullAdder full = new FullAdder();
		Switch inA = new Switch();
		Switch inB = new Switch();
		Switch inC = new Switch();
		
		inA.setOutputValue(true);
		inB.setOutputValue(false);
		inC.setOutputValue(false);
		InputPin pinA = new InputPin();
		InputPin pinB = new InputPin();
		InputPin pinC = new InputPin();
		pinA.setSource(inA);
		pinB.setSource(inB);
		pinC.setSource(inC);
		
		full.setPinA(pinA);
		full.setPinB(pinB);
		full.setPinC(pinC);
				
		
		Assert.assertTrue(full.getOutputValue(0));
		Assert.assertFalse(full.getOutputValue(1));
		
	}
	
	@Test
	public void comEntradaFalseTrueFalse() {
		FullAdder full = new FullAdder();
		Switch inA = new Switch();
		Switch inB = new Switch();
		Switch inC = new Switch();
		
		inA.setOutputValue(false);
		inB.setOutputValue(true);
		inC.setOutputValue(false);
		InputPin pinA = new InputPin();
		InputPin pinB = new InputPin();
		InputPin pinC = new InputPin();
		pinA.setSource(inA);
		pinB.setSource(inB);
		pinC.setSource(inC);
		
		full.setPinA(pinA);
		full.setPinB(pinB);
		full.setPinC(pinC);
				
		
		Assert.assertTrue(full.getOutputValue(0));
		Assert.assertFalse(full.getOutputValue(1));
		
	}
	
	@Test
	public void comEntradaFalseFalseTrue() {
		FullAdder full = new FullAdder();
		Switch inA = new Switch();
		Switch inB = new Switch();
		Switch inC = new Switch();
		
		inA.setOutputValue(false);
		inB.setOutputValue(false);
		inC.setOutputValue(true);
		InputPin pinA = new InputPin();
		InputPin pinB = new InputPin();
		InputPin pinC = new InputPin();
		pinA.setSource(inA);
		pinB.setSource(inB);
		pinC.setSource(inC);
		
		full.setPinA(pinA);
		full.setPinB(pinB);
		full.setPinC(pinC);
				
		
		Assert.assertTrue(full.getOutputValue(0));
		Assert.assertFalse(full.getOutputValue(1));
		
	}
	
	@Test
	public void comEntradaFalseFalseFalse() {
		FullAdder full = new FullAdder();
		Switch inA = new Switch();
		Switch inB = new Switch();
		Switch inC = new Switch();
		
		inA.setOutputValue(false);
		inB.setOutputValue(false);
		inC.setOutputValue(false);
		InputPin pinA = new InputPin();
		InputPin pinB = new InputPin();
		InputPin pinC = new InputPin();
		pinA.setSource(inA);
		pinB.setSource(inB);
		pinC.setSource(inC);
		
		full.setPinA(pinA);
		full.setPinB(pinB);
		full.setPinC(pinC);
				
		
		Assert.assertFalse(full.getOutputValue(0));
		Assert.assertFalse(full.getOutputValue(1));
		
	}
}
