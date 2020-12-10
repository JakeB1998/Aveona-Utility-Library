/**
 * ArrayUtilTests.java
 * Programmer: Jake Botka
 * Oct 29, 2020
 *
 */
package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.org.botka.utility.api.exceptions.IllegalNullArguementException;
import main.org.botka.utility.api.exceptions.NotImplementedYetException;
import main.org.botka.utility.api.util.ArrayUtil;
import main.org.botka.utility.api.util.ListUtil;
import main.org.botka.utility.api.util.Util;

/**
 * @author Jake Botka
 *
 */
public class ArrayUtilTests {

	private List<String> mListData;

	/**
	 * @throws java.lang.Exception
	 * 
	 */
	@Before
	public void setUp() throws Exception {
		mListData = new ArrayList(Arrays.asList(TestData.STRING_DATA_MEDIUM_SIZE));
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
		ListUtil.safeRemoveAll(this.mListData);
		assertEquals(0, this.mListData.size());
	}
	
	@Test
	public void removeSingleTest() {
		String s = this.mListData.get(3);
		String removedElement = ListUtil.safeRemove(this.mListData, 3);
		assertEquals(s, removedElement);
	}

	@Test
	public void failTest() {
		try {
			for (String x : this.mListData) {
				this.mListData.remove(x);
				
			}
		} catch (Exception e) {
			assertEquals(e.getClass(), ConcurrentModificationException.class);
		}
		
	}
	
	@Test
	public void copyTests() {
		int offset = 0;
		int amount = 90;
		int[] arr = ArrayUtil.arrange(0, 101);
		int[] intRes = ArrayUtil.copy(arr,offset,amount);
		ArrayUtil.print(intRes);
		assertEquals(Arrays.toString(intRes), Arrays.toString(ArrayUtil.arrange(0, amount)));
		
		offset = 5;
		intRes = ArrayUtil.copy(arr,offset,amount);
		ArrayUtil.print(intRes);
		assertEquals(intRes, ArrayUtil.arrange(0, amount));
		
		//add more
	}

	

}
