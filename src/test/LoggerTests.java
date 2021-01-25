/**
 * LoggerTests.java
 * Programmer: Jake Botka
 * Oct 25, 2020
 *
 */
package test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javafx.concurrent.Task;
import main.org.botka.utility.api.logger.BaseLogger;
import main.org.botka.utility.api.logger.FileLogger;
import main.org.botka.utility.api.logger.Log;
import main.org.botka.utility.api.logger.LogHistoryRecorder;
import main.org.botka.utility.api.logger.LogRecorder;
import main.org.botka.utility.api.logger.Logger;
import main.org.botka.utility.api.logger.SynchronizedLogHistoryRecorder;
import main.org.botka.utility.api.logger.SynchronizedLogRecroder;
import main.org.botka.utility.api.util.ArrayUtil;
import main.org.botka.utility.api.util.FileUtil;

/**
 * @author Jake Botka
 *
 */
public class LoggerTests {

	private Logger mLogger;
	private Logger mDefaultLogger;
	private Logger mFileLogger;
	/**
	 * @throws java.lang.Exception
	 * 
	 */
	@Before
	public void setUp() throws Exception {
		this.mLogger = new BaseLogger(LogHistoryRecorder.getDefaultLogRecorder());
		this.mDefaultLogger = new BaseLogger();
		File file = FileUtil.findOrCreate("testlogger.LOG");
		this.mFileLogger = new FileLogger(file , true,false);
		
	}

	/**
	 * @throws java.lang.Exception
	 * 
	 */
	@After
	public void tearDown() throws Exception {
		this.mLogger = null;
		this.mDefaultLogger = null;
		
	}

	@Test
	public void defaultLogTest() {
		assertNotNull(this.mDefaultLogger.getLogRecorder());
	}
	
	@Test
	public void logStringTest() {
		
		this.mLogger.log(new Log<String>(new String("This is a log")));
		assertEquals(1, this.mLogger.getLogRecorder().getLogCount());
		assertEquals(new String("This is a log"), (String)this.mLogger.getLogRecorder().getLogs()[0].getLog());
	}
	
	@Test
	public void logObjectTest() {
		
		this.mLogger.log(new Log<String>(new String("This is a log")));
		assertEquals(1, this.mLogger.getLogRecorder().getLogCount());
		assertEquals(new String("This is a log"), (String)this.mLogger.getLogRecorder().getLogs()[0].getLog());
		this.mLogger.log(new Log<Integer>(5));
		assertEquals(2, this.mLogger.getLogRecorder().getLogCount());
		assertEquals(new Integer(5), (Integer)this.mLogger.getLogRecorder().getLogs()[1].getLog());
	}
	


	@Test
	public void fileLoggerTest() {
		this.mFileLogger.log("Hello this is the first log");
		this.mFileLogger.log(new Log<>("This is the second log", true));
		this.mFileLogger.log(new Log<>("This is the long log....I am trying to close my laptop lid without anything happening to my 2nd monitor."
				+ "Lets say I've got streaming video up on my second monitor, all nice and full screen- and I have email and other boring stuff on my primary, laptop screen. "
				+ "I'm done, want to kick back, and enjoy the end of a movie, so I close the lid of my laptop- now everything moves onto the 2nd external monitor as if it was the single primary monitor."
				+ " I just want it to stay the same. As if I had only turned one monitor off.", true));
		FileLogger logger = (FileLogger)this.mFileLogger;
		
	}
	
	@Test
	public void synchronizedLogTests() {
		final SynchronizedLogHistoryRecorder record = new SynchronizedLogHistoryRecorder();
		final ExecutorService executorService = Executors.newFixedThreadPool(20);
		
		int[] content = ArrayUtil.arrange(100);
		Callable<Log<String>>[] logs = new Callable[100];
		int index = 0;
		for (int x : content) {
			logs[index] = new Callable<Log<String>>() {
				@Override
				public Log<String> call() throws Exception {
					Log log = new Log<String>(String.valueOf(x));
					record.blockingRecordLog(log);
					return log;
				}
			};
			index++;
		}
		Collection<Callable<Log<String>>> tasks = Arrays.asList(logs);
		try {
			List<Future<Log<String>>> list = executorService.invokeAll(tasks);
			while (true && list.size() > 0) {
				Iterator<Future<Log<String>>> iterator = list.iterator();
				while (iterator.hasNext()) {
					Future<Log<String>> future = iterator.next();
					if (future.isDone()) {
						try {
							Log<String> log  = future.get();
							synchronized (System.out){
						        System.out.println(log.getLog());
						    }
							
						} catch (ExecutionException e) {
							e.printStackTrace();
						}
						iterator.remove();
					}
				}
			}
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
}
