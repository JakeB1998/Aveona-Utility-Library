/**
 * Tester.java
 * Programmer: Jake Botka
 * Nov 4, 2020
 *
 */
package test;

import static org.junit.Assert.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.junit.Test;

/**
 * @author Jake Botka
 *
 */
public class Tester {

	final CountDownLatch lockCount = new CountDownLatch(1);
	@Test
	public void test() {
		final ReadWrite<Integer> readWrite = new ReadWrite<>();
		final ExecutorService executorService = Executors.newFixedThreadPool(100);
		final AtomicBoolean doneWrite = new AtomicBoolean(false);
		final AtomicInteger runs = new AtomicInteger();
		Vector<Integer[]> history = new Vector();

		for (int i =0 ; i < 1; i++) {
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					
					while (doneWrite.get() == false || readWrite.mSize.get() < 1000 ) {
						
						history.add(readWrite.read().toArray(new Integer[0]));
						
					}
					
				}
			});
		}
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					
					int runsI = runs.get();
					
					final Vector<Integer> backlog = new Vector<>();
					while (true && runsI <= 1000) {
						final Integer num = runs.getAndIncrement();
						runsI = num.intValue();
						if (readWrite.getLock().writeLock().tryLock()) {
							if (backlog.size() == 0) {
								readWrite.write(num);
								
							}
							else {
								backlog.add(num);
								Integer[] arr = backlog.toArray(new Integer[0]);
								backlog.clear();
								readWrite.write(arr);
							}
						}
						else {
							backlog.add(num);
						}
						
						
					}
					
					if (backlog.size() > 0) {
						Integer[] arr = backlog.toArray(new Integer[0]);
						backlog.clear();
						readWrite.write(arr);
					}
					
					doneWrite.set(true);
				}
			});

			
			
			List<Runnable> uncompleted = executorService.shutdownNow();
			try {
				executorService.awaitTermination(5, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			int index = 0;
			Iterator<Integer[]> iterator = history.iterator();
		while(iterator.hasNext()) {
			Integer[] v = iterator.next();
			System.out.println("\nStart: " + index);
			index++;
			for (Integer i : v) {
				System.out.println(" " + i.intValue());
			}
		}
	
		assertEquals(5, history.size());
	}

	public static class ReadWrite<T> {
		private ReadWriteLock mLock = new ReentrantReadWriteLock();
		private Vector<T> mVector = new Vector<>();
		private Vector<Vector<T>> versionHistory = new Vector<>();
		public AtomicInteger mSize = new AtomicInteger();
		CountDownLatch lock = new CountDownLatch(1);
		
		public ReadWriteLock getLock() {
			return  this.mLock;
		}
		public ReadWrite() {
			
		}
		
		public void write(T value) {
			//System.out.println("write");
			/*
			while(!this.mLock.writeLock().tryLock()) {
				try {
					
					lock.await(500, TimeUnit.MILLISECONDS);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(LocalTime.now().format(DateTimeFormatter.ISO_TIME));
			}
			*/
			
			try {
				this.mVector.add(value);
				
			} finally {
				this.mLock.writeLock().unlock();
				
			}
			
			
		}
		
		public void write(T[] value) {
			//System.out.println("write");
			this.mLock.writeLock().lock();
			try {
				for (T t : value) {
					this.mVector.add(t);
					this.mSize.incrementAndGet();
				}
			} finally {
				this.mLock.writeLock().unlock();
				
			}
		}
		public Vector<T> read() {
			System.out.println("Read");
			Vector<T> arr = new Vector<>();
			this.mLock.readLock().lock();
			
			try {
				Iterator<T> iterator = this.mVector.iterator();
				while(iterator.hasNext()) {
					arr.add(iterator.next());
				}
			} finally {
				this.mLock.readLock().unlock();
				
			}
			return arr;
			
		}
	}
	
	
}
