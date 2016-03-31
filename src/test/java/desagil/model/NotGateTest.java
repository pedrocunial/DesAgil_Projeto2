package desagil.model;

import org.junit.Assert;
import org.junit.Test;

public class NotGateTest {
	
	@Test
	public void comEntradaPlausivel() {
		NotGate not = new NotGate();
		
		Assert.assertFalse(not.getOutputValue(1));
		Assert.assertTrue(not.getOutputValue(0));
		
	}

}
