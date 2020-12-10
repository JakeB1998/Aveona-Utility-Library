/**
 * MultiDimensionalArrayTests.java
 * Programmer: Jake Botka
 * Nov 4, 2020
 *
 */
package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.org.botka.utility.api.data.structures.arrays.MultiDimensionalArray;

/**
 * @author Jake Botka
 *
 */
public class MultiDimensionalArrayTests {

	private MultiDimensionalArray<Integer> mArr;
	/**
	 * @throws java.lang.Exception
	 * 
	 */
	@Before
	public void setUp() throws Exception {
		int[] shape = {3,3,3};
		this.mArr = new MultiDimensionalArray<Integer>(shape);
	}

	/**
	 * @throws java.lang.Exception
	 * 
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void findTest() {
		this.mArr.fillWith(new Integer(5));
		int[] indices = {2,2,2};
		boolean flag = this.mArr.addAt(indices, new Integer(2));
		assertTrue(flag);
		Integer value = this.mArr.getItem(indices);
		System.out.println(value);
		assertEquals(value, new Integer(2));
	}

}
