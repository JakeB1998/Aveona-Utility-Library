/**
 * NonceGeneratorTests.java
 * Programmer: Jake Botka
 * Nov 1, 2020
 *
 */
package test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.org.botka.utility.api.security.Nonce;
import main.org.botka.utility.api.security.NonceGenerator;
import main.org.botka.utility.api.security.SequentialNonceGenerator;

/**
 * @author Jake Botka
 *
 */
public class NonceGeneratorTests {
	NonceGenerator generator = null;
	Nonce[] sortedNonces = {new Nonce(4), new Nonce(2)};
	int[] sortedNoncesInt = null;
	/**
	 * @throws java.lang.Exception
	 * 
	 */
	@Before
	public void setUp() throws Exception {
		sortedNoncesInt = new Random().ints(100, 0, 1000).toArray();
		generator = new SequentialNonceGenerator(sortedNoncesInt);
	}

	/**
	 * @throws java.lang.Exception
	 * 
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		generator.getUsedNonces();
		
		assertNotNull(NonceGenerator.generateNonce(new int[0]));
		assertNotEquals(new Integer(1),new Integer(generator.nextNounce()));
	}

}
