package desagil.model;

import org.junit.Assert;
import org.junit.Test;

public class HalfAdderTest {
	
	@Test
	public void comEntradaTrueTrue() {
		HalfAdder halfAdder = new HalfAdder();
		Switch inA = new Switch();
		Switch inB = new Switch();
		
		inA.setOutputValue(true);
		inB.setOutputValue(true);
		InputPin pinA = new InputPin();
		InputPin pinB = new InputPin();
		pinA.setSource(inA);
		pinB.setSource(inB);
		
		halfAdder.setPinA(pinA);
		halfAdder.setPinB(pinB);
		
		Assert.assertFalse(halfAdder.getOutputValue(0));
		Assert.assertTrue(halfAdder.getOutputValue(1));
		
	}
	
	@Test
	public void comEntradaTrueFalse() {
		HalfAdder halfAdder = new HalfAdder();
		Switch inA = new Switch();
		Switch inB = new Switch();
		
		inA.setOutputValue(true);
		inB.setOutputValue(false);
		InputPin pinA = new InputPin();
		InputPin pinB = new InputPin();
		pinA.setSource(inA);
		pinB.setSource(inB);
		
		halfAdder.setPinA(pinA);
		halfAdder.setPinB(pinB);
		
		Assert.assertTrue(halfAdder.getOutputValue(0));
		Assert.assertFalse(halfAdder.getOutputValue(1));
		
	}
	
	@Test
	public void comEntradaFalseTrue() {
		HalfAdder halfAdder = new HalfAdder();
		Switch inA = new Switch();
		Switch inB = new Switch();
		
		inA.setOutputValue(false);
		inB.setOutputValue(true);
		InputPin pinA = new InputPin();
		InputPin pinB = new InputPin();
		pinA.setSource(inA);
		pinB.setSource(inB);
		
		halfAdder.setPinA(pinA);
		halfAdder.setPinB(pinB);
		
		Assert.assertTrue(halfAdder.getOutputValue(0));
		Assert.assertFalse(halfAdder.getOutputValue(1));
		
	}
	
	@Test
	public void comEntradaFalseFalse() {
		HalfAdder halfAdder = new HalfAdder();
		Switch inA = new Switch();
		Switch inB = new Switch();
		
		inA.setOutputValue(false);
		inB.setOutputValue(false);
		InputPin pinA = new InputPin();
		InputPin pinB = new InputPin();
		pinA.setSource(inA);
		pinB.setSource(inB);
		
		halfAdder.setPinA(pinA);
		halfAdder.setPinB(pinB);
		
		Assert.assertFalse(halfAdder.getOutputValue(0));
		Assert.assertFalse(halfAdder.getOutputValue(1));
		
	}
		
}
