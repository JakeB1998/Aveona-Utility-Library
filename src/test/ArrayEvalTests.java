/**
 * ArrayEvalTests.java
 * Programmer: Jake Botka
 * Oct 29, 2020
 *
 */
package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.org.botka.utility.api.data.structures.arrays.ArrayEval;

/**
 * @author Jake Botka
 *
 */
public class ArrayEvalTests {

	
	/**
	 * @throws java.lang.Exception
	 * 
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 * 
	 */
	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void medianTest() {
		assertEquals(new Double(12.232), new Double(ArrayEval.min(TestData.DOUBLE_DATA_SMALL_SIZE)));
	}
	
	@Test
	public void meanTest() {
		
	}
	
	

}
