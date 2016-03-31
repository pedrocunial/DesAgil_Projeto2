package desagil.model;

import org.junit.Assert;
import org.junit.Test;


public class NotGateTest {
	
	@Test
	public void comEntradaTrue() {
		NotGate not = new NotGate();
		Switch in = new Switch();
		
		in.setOutputValue(true);
		InputPin pinA = new InputPin();
		pinA.setSource(in);
		pinA.setIndex(0);
		
		not.setPinA(pinA);
		
		Assert.assertFalse(not.getOutputValue(0));		
	
	}
	
	@Test
	public void comEntradaFalse() {
		NotGate not = new NotGate();
		Switch in = new Switch();
		
		in.setOutputValue(false);
		InputPin pinA = new InputPin();
		pinA.setSource(in);
		pinA.setIndex(1);
		
		not.setPinA(pinA);
		
		Assert.assertTrue(not.getOutputValue(1));
		
	}

}
