/**
 * FileUtilTests.java
 * Programmer: Jake Botka
 * Nov 14, 2020
 *
 */
package test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Paths;
import java.util.Vector;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javafx.scene.input.InputEvent;
import main.org.botka.utility.api.util.ArrayUtil;
import main.org.botka.utility.api.util.FileUtil;

/**
 * @author Jake Botka
 *
 */
public class FileUtilTests {

	String filePath = "test file.txt";
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

	@Test
	public void fileFindTest() {
		File file = FileUtil.findOrCreate(filePath);
		assertNotNull(file);
		assertTrue(file.exists());
		assertEquals(0, file.length());
		assertEquals(filePath, file.getPath());
		assertNotNull(FileUtil.findFile(filePath));
	}
	
	@Test
	public void writeDataToFileTest() {
		File file = new File("testDirectory/RandomTestFile1.txt");
		byte[] data = new String("Big test").getBytes();
		assertNotNull(file);
		assertNotNull(data);
		try {
			FileUtil.writeDataToFile(data, file);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			fail(e.getMessage());
		}
		FileInputStream fileIn;
		try {
			fileIn = new FileInputStream(file);
			ObjectInputStream objIn = new ObjectInputStream(fileIn);
			
			int byteValue = -1;
			int count = 0;
			byte[] data2 = new byte[100];
			
			while ((byteValue = objIn.read()) != -1) {
				data2[count] = (byte) byteValue;
				count++;
			}
			data2 = ArrayUtil.copy(data2, count);		
			assertEquals(data.length, data2.length);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void moveFileTest() {
		File file = new File("testDirectory/RandomTestFile.txt");
		if (!file.exists()) {
			file = new File("testDirectory/nested-dir/RandomTestFile.txt");
		}
		File parent = file.getParentFile();
		System.out.println(parent.getAbsolutePath());
		File newFile = parent.toPath().resolve("nested-dir").toFile();
		
		newFile = FileUtil.moveTo(file, newFile);
		System.out.println(newFile.getAbsolutePath());
		newFile = FileUtil.moveTo(newFile, file.getParent());
		System.out.println(newFile.getAbsolutePath());
		newFile = FileUtil.moveTo(newFile,parent.toPath().resolve("nested-dir").toFile().getPath() );
		System.out.println(newFile.getAbsolutePath());
	}

}
