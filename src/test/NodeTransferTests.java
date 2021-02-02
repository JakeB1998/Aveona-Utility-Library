/**
 * NodeTransferTests.java
 * Programmer: Jake Botka
 * Nov 14, 2020
 *
 */
package test;

import static org.junit.Assert.*;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.eclipse.jdt.annotation.NonNull;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.org.botka.utility.api.base.RandomGenerator;

import test.NodeTransferTests.MinerNode.Manager;

/**
 * @author Jake Botka
 *
 */
public class NodeTransferTests {

	public static final int MINER_COUNT = 20;
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

	CountDownLatch lock = new CountDownLatch(1);
	@Test
	public void test() {
		MinerNode[] miners = new MinerNode[MINER_COUNT];
		
		for (int i =0; i < MINER_COUNT; i++) {
			miners[i] = (new MinerNode(generateSecureID(9), RandomGenerator.generateRandomInt(100)));
		}
		Manager manager = new Manager(1,miners);
		manager.start();
		try {
			lock.await(30,TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println("\nResults\n");
		System.out.println(manager);
		for (MinerNode node : manager.getMiners()) {
			System.out.println(node);
		}
		assertTrue(true);
	}
	public static final SecureRandom SECURE_RANDOM = new SecureRandom();
	public static int generateSecureID(int length) {
		String id = "";
		for (int i =0; i < length; i++) {
			id += String.valueOf(SECURE_RANDOM.nextInt(9));
		}
		return id.length() > 0 ? Integer.parseInt(id) : -1;
	}

	/**
	 * 
	 * @author Jake Botka
	 *
	 */
	public static class MinerNode implements Comparable<MinerNode>, Runnable {
		private int mID;
		private int mThreshold;
		private int mPOIScore;
		private AtomicInteger mCurrentThresh;
		private AtomicInteger mTransactionCount;
		private Vector<Transaction> mCommitTransactions;
		private Vector<Transaction> mPreprossesedTransactions;
		private final ExecutorService mExecutors = Executors.newFixedThreadPool(5);
		
		public MinerNode() {
			this.mTransactionCount = new AtomicInteger(0);
			this.mCurrentThresh = new AtomicInteger(0);
			this.mCommitTransactions = new Vector<>();
			this.mPreprossesedTransactions = new Vector<>();
		}
		
		public MinerNode(int id , int threshold) {
			this();
			this.mID = id;
			this.mThreshold = threshold;
			this.mExecutors.submit(this);
		}
		
		public synchronized boolean commitTransaction(@NonNull Transaction transaction) {
			if (transaction == null) {
				throw new NullPointerException();
			}
			this.mTransactionCount.getAndIncrement();
			this.mCurrentThresh.getAndIncrement();
			this.mCommitTransactions.add(transaction);
			//System.out.println( this.getID() + ": Transaction commited");
			return true;
			//return false;
		}
		
		public synchronized void removeTransaction(List<Transaction> list, Transaction transaction) {
			Iterator iterator = list.iterator();
			while (iterator.hasNext()) {
				Transaction transactionElement = (Transaction) iterator.next();
				if (transactionElement.equals(transaction)) {
					iterator.remove();
					break;
				}
			}
		}
		public synchronized Transaction getNextTransaction() {
			Iterator iterator=  getCommitedTransactions().iterator();
			if (iterator.hasNext()) {
				Object next = iterator.next();
				iterator.remove();
				return (Transaction) next;
			}
			
			return null;
		}
		
		
		public synchronized Vector<Transaction> getCommitedTransactions() {
			return this.mCommitTransactions;
		}
		public synchronized Vector<Transaction> getprepossedTransactions() {
			return this.mCommitTransactions;
		}
		
		public synchronized boolean hasMetThreshold() {
			return this.mCurrentThresh.get() == this.mThreshold;
		}
		public int getID() {
			return this.mID;
		}

		@Override
		public int compareTo(MinerNode o) {
			// TODO Auto-generated method stub
			return o.mThreshold - this.mThreshold;
		}
		
		

		@Override
		public boolean equals(Object obj) {
			MinerNode miner = (MinerNode) obj;
			if (miner.getID() == this.getID()) {
				return true;
			}
			return false;
		}

		@Override
		public String toString() {
			return "MinerNode [mID=" + mID + ", mThreshold=" + mThreshold + ", mPOIScore=" + mPOIScore
					+ ", mCurrentThresh=" + mCurrentThresh.get() + ", mTransactionCount=" + mTransactionCount.get()
					+ ", mCommitTransactions=" + mCommitTransactions + ", mPreprossesedTransactions="
					+ mPreprossesedTransactions  + "]";
		}

		@Override
		public void run() {
			while (true) {
				if (this.getCommitedTransactions().size() > 0) {
				Transaction tran = this.getNextTransaction();
				if (tran != null) {
						Future<TaskResult> future = this.mExecutors.submit(new TaskResult(this, tran));
						try {
							
							TaskResult result = future.get();
							//System.out.println("Result : " + result);
							if (result.hasResult() && result.getResult() == true) {
								Transaction transaction = result.getTransaction();
								this.mPreprossesedTransactions.add(transaction);
								this.mCurrentThresh.getAndDecrement();
								
							}
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ExecutionException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}	
			}
		
	}
	
	public static class TaskResult implements Callable<TaskResult> {
		private MinerNode mMiner;
		private Transaction mTransaction;
		private AtomicBoolean mResult;
		private Boolean mPredetermined;
		
		public TaskResult(MinerNode miner, Transaction transaction) {
			this.mMiner = miner;
			this.mTransaction = transaction;
			this.mResult = null;
			this.mPredetermined = null;
		}
		public TaskResult(MinerNode miner, Transaction transaction, boolean predeterminedResult) {
			this(miner,transaction);
			this.mPredetermined = new Boolean(predeterminedResult);
		}
		@Override
		public TaskResult call() throws Exception {
			//System.out.println("Proccessing for miner: " + this.mMiner);
			this.doProccessing();
			return this;
		}
		
		public boolean doProccessing() {
			try {
				try {
					Executors.newSingleThreadExecutor().submit(new Callable<Boolean>() {
						public Boolean call() {
							try {
								new CountDownLatch(1).await(500, TimeUnit.MILLISECONDS);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							return null;
						}
					}
					).get();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.mResult = this.mPredetermined != null ? new AtomicBoolean(mPredetermined.booleanValue()) : new AtomicBoolean(true);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return true;
			
		}
		public boolean hasResult() {
			return this.mResult != null;
		}
		public boolean getResult() {
			return this.mResult != null ? this.mResult.get() : false;
		}
		public Transaction getTransaction() {
			return this.mTransaction;
		}
		@Override
		public String toString() {
			return "TaskResult [mMiner=" + mMiner + ", mTransaction=" + mTransaction + ", mResult=" + mResult
					+ ", mPredetermined=" + mPredetermined + ", "+ ", doProccessing()="
					+ doProccessing() + ", hasResult()=" + hasResult() + ", getResult()=" + getResult()
					+ ", getTransaction()=" + getTransaction() + ", getClass()=" + getClass() + ", hashCode()="
					+ hashCode() + ", toString()=" + super.toString() + "]";
		}
	}
	
	public static class Transaction  {
		private int mID;
		private MinerNode mMinerSource;
		public Transaction() {
			this.mMinerSource = null;
		}
		public Transaction(int id) {
			this();
			this.mID = id;
		}
		
		public int getID() {
			return this.mID;
		}
		
		public void setMinerSource(MinerNode miner) {
			this.mMinerSource = miner;
		}
		
		public boolean equals(Object o) {
			Transaction tran = (Transaction)o;
			if (tran.getID() == this.getID()) {
				return true;
			}
			return false;
		}
		@Override
		public String toString() {
			return "Transaction [mID=" + mID + ", mMinerSource=" + mMinerSource + ", getID()=" + getID()
					+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
					+ "]";
		}
	}
	/**
	 * 
	 * @author Jake Botka
	 *
	 */
	public static class Manager implements Runnable {
		@Override
		public String toString() {
			return "Manager [mID=" + mID + ", mMiners=" + mMiners + ", mSortedMiners=" + mSortedMiners + ", mExecutor="
					+ mExecutor + ", mKeepGoing=" + mKeepGoing + ", generateTransaction()=" + generateTransaction()
					+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
					+ "]";
		}

		private int mID;
		private HashMap<Integer, MinerNode> mMiners;
		private ArrayList<MinerNode> mSortedMiners;
		private ExecutorService mExecutor;
		private volatile boolean mKeepGoing;
		public Manager() {
			this.mMiners = new HashMap<>(0);
			this.mExecutor = Executors.newSingleThreadExecutor();
			this.mSortedMiners = new ArrayList<>();
			
		}
		
		public Manager(int id) {
			this();
			this.mID = id;
		}
		
		public Manager(int id, @NonNull MinerNode[] miners) {
			this(id);
			if (miners == null) {
				throw new NullPointerException();
			}
			for (@NonNull MinerNode miner : miners) {
				if (miner == null) {
					throw new NullPointerException();
				}
				this.addMiner(miner);
			}
		}
		
		public void start() {
			this.mKeepGoing = true;
			this.mExecutor.submit(this);
		}
		
		public void stop() {
			this.mKeepGoing = false;
		}
		public void doTransaction() {
			Transaction transaction = this.generateTransaction();
			int start = 0;
			MinerNode miner = null;
			do {
			 miner = decideOnMiner(start);
			 start++;
			}
			while (!miner.commitTransaction(transaction));
			//System.err.println("Transaction: " + transaction.getID() + " Has been commited");
			
		}
		
		public MinerNode decideOnMiner(int offset) {
			for (int i = offset; i < this.mSortedMiners.size(); i++) {
				MinerNode miner = this.mSortedMiners.get(i);
				if (!miner.hasMetThreshold()) {
					return miner;
				}
			}
			return null;
		}
		public Transaction generateTransaction() {
			int id = generateSecureID(9);
			return new Transaction(id);
		}
		public void addMiner(@NonNull MinerNode miner) {
			if (miner == null) {
				throw new NullPointerException();
			}
			Integer key = new Integer(miner.getID());
			if(!this.mMiners.containsKey(key)){
				this.mMiners.put(key, miner);
				this.mSortedMiners.add(miner);
			} else {
				System.out.println(miner.toString() +  " Is already in manager");
			}
			Collections.sort(this.mSortedMiners);
			
		}

		public MinerNode[] getMiners() {
			return this.mSortedMiners.toArray(new MinerNode[0]);
		}
		@Override
		public void run() {
			CountDownLatch lock = new CountDownLatch(1);
			while (this.mKeepGoing) {
				
				this.doTransaction();
				try {
					lock.await(10, TimeUnit.MILLISECONDS);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			System.err.println("Loop broken");
			
		}
	}
	
	}	
}
