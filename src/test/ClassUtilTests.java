/**
 * ClassUtilTests.java
 * Programmer: Jake Botka
 * Nov 23, 2020
 *
 */
package test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.org.botka.utility.api.data.structures.maps.FileMap;
import main.org.botka.utility.api.util.ClassUtil;

/**
 * @author Jake Botka
 *
 */
public class ClassUtilTests {

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
	 * Test method for {@link main.org.botka.utility.api.util.ClassUtil#loadClassByName(java.lang.String)}.
	 */
	@Test
	public void testLoadClassByName() {
		try {
			assertEquals(getClass(), ClassUtil.loadClassByName(getClass().getCanonicalName()));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Test method for {@link main.org.botka.utility.api.util.ClassUtil#invokeMethod(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])}.
	 */
	@Test
	public void testInvokeMethod() {
		FileMap<String> map = new FileMap<>();
		boolean x = map.addFile("HI", new File("testlogger.LOG"));
		assertEquals(new Integer(1), ClassUtil.invokeMethod(map, ClassUtil.findMethod(FileMap.class, "sizeOfMap"), new Class<?>[0]));
		Object returnObj = ClassUtil.invokeMethod(map, ClassUtil.findMethod(FileMap.class, "clearMap"), new Class<?>[0]);
		returnObj = ClassUtil.invokeMethod(map, ClassUtil.findMethod(FileMap.class, "sizeOfMap"), new Class<?>[0]);
		assertNotNull(returnObj);
		assertEquals(Integer.class, returnObj.getClass());
		assertEquals(new Integer(0),returnObj);
	}

	/**
	 * Test method for {@link main.org.botka.openjdk.api.addon.util.ClassUtil#findMethod(java.lang.Class, java.lang.String, java.lang.Class<?>[])}.
	 */
	@Test
	public void testFindMethod() {
		fail("Not yet implemented");
	}

}
