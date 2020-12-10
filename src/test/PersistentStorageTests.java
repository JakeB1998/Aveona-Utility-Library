/**
 * PersistentStorageTests.java
 * Programmer: Jake Botka
 * Dec 2, 2020
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

import main.org.botka.utility.api.data.storage.PersistentStorage;
import main.org.botka.utility.api.util.FileUtil;

/**
 * @author Jake Botka
 *
 */
public class PersistentStorageTests {

	private final PersistentStorage mPerStorage = new PersistentStorage(FileUtil.findOrCreateDirectory(new File("testDirectory")));

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		File file = this.mPerStorage.storeData(new String("This si a test").getBytes(), new File("testFile.txt"));
		System.out.println(file.getAbsolutePath());
		fail();
		

	}

}
