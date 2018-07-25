package Question1;

import static org.junit.Assert.*;

import org.junit.Test;

public class LcmHcfTest {

	@Test
	public void testForHCF() {
		int result = LcmHcf.calculateHCF(366, 60);
		assertEquals(6, result);
	}

	@Test
	public void testForLCM() {
		int result = LcmHcf.calculateLCM(2, 3);
		assertEquals(6, result);
	}
}
