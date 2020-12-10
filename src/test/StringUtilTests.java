/**
 * StringUtilTests.java
 * Programmer: Jake Botka
 * Nov 24, 2020
 *
 */
package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.org.botka.utility.api.util.StringUtil;

/**
 * @author Jake Botka
 *
 */
public class StringUtilTests {

	/**
	 * @throws java.lang.Exception
	 * 
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 * 
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

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

	/**
	 * Test method for {@link main.org.botka.utility.api.util.StringUtil#pasrAfter(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testPasreAfter() {
		String source = "abcd(jake";
		assertEquals("jake", StringUtil.parseAfter(source, "("));
		assertNull(StringUtil.parseAfter(source, "ke"));
		
	}

	/**
	 * Test method for {@link main.org.botka.utility.api.util.StringUtil#pasreBefore(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testParseBefore() {
		String source = "abcd(jake";
		assertEquals("abcd", StringUtil.parseBefore(source, "("));
		assertNull(StringUtil.parseBefore(source, "ab"));
	}

	/**
	 * Test method for {@link main.org.botka.utility.api.util.StringUtil#parseBetween(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testParseBetween() {
		String source = "abcd(jake";
		String source2 = "abcd()jake";
		assertEquals("jak", StringUtil.parseBetween(source, "(", "e"));
		assertNull(StringUtil.parseBetween(source, "(", ")"));
		
		assertNull(StringUtil.parseBetween(source2, "(", ")"));
	}

	/**
	 * Test method for {@link main.org.botka.utility.api.util.StringUtil#insert(java.lang.String, java.lang.String, int)}.
	 */
	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link main.org.botka.utility.api.util.StringUtil#remove()}.
	 */
	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

	
}
