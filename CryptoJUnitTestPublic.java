package src;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CryptoJUnitTestPublic {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.stringInBounds("THIS TEST SHOULD SUCCEED"));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("IFMMP!XPSME", CryptoManager.encryptCaesar("HELLO WORLD", 1));
	}
	
	@Test
	public void testDecryptCaesar() {
		assertEquals("HELLO WORLD", CryptoManager.decryptCaesar("IFMMP!XPSME", 1));
	}


}