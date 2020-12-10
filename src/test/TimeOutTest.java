/**
 * TimeOutTest.java
 * Programmer: Jake Botka
 * Nov 26, 2020
 *
 */
package test;

import static org.junit.Assert.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.org.botka.utility.api.base.Timeout;
import main.org.botka.utility.api.base.TimeoutListener;
import main.org.botka.utility.api.time.Stopwatch;

/**
 * @author Jake Botka
 *
 */
public class TimeOutTest {

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
	public void test() {
		final Stopwatch stopwatch = new Stopwatch();
		stopwatch.start();
		new Timeout(3, TimeUnit.SECONDS, new TimeoutListener() {
			@Override
			public void onTimeout(long amount, TimeUnit timeUnit) {
				stopwatch.stop();
				stopwatch.printResults();
				assertTrue(true);
			}
		});
		stopwatch.printResults();
		try {
			new CountDownLatch(1).await(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	

}
