/**
 * File Name: IncrementableInt.java
 * Programmer: Jake Botka
 * Date Created: Jan 25, 2021
 *
 */
package main.org.botka.utility.api.base;

/**
 * @author Jake Botka
 *
 */
public class IncrementableInt implements Incrementable<IncrementableInt>, Comparable<IncrementableInt>{

	private int mCurrentValue;
	private int mIncrementStep;
	
	/**
	 * Default constructor.
	 * Increment step is set to one by default. 
	 */
	public IncrementableInt() {
		mIncrementStep = 1;
		mCurrentValue = Integer.MIN_VALUE;
	}
	
	public IncrementableInt(int startingValue) {
		this(startingValue, 1);
	}
	
	
	public IncrementableInt(int startingValue, int incrementStep) {
		mCurrentValue = startingValue;
		mIncrementStep = incrementStep;
	}

	/**
	 * @param o
	 * @return
	 */
	@Override
	public int compareTo(IncrementableInt o) {
		return o != null ? this.getCurrentValue() - o.getCurrentValue() : 0;
	}

	/**
	 * @param incrementableValue
	 * @return
	 * 
	 */
	@Override
	public IncrementableInt increment() {
		if (  canIncrement()) {
			setCurrentValue(getCurrentValue() + getStep());
			return this;
		}
		return null;
	}

	/**
	 * @param incrementableValue
	 * @return
	 * 
	 */
	@Override
	public IncrementableInt decrement() {
		setCurrentValue(getCurrentValue() - getStep());
		return this;

	}

	/**
	 * @param incrementableValue
	 * @return
	 * 
	 */
	@Override
	public boolean canIncrement() {
		int nValue = getCurrentValue() + getStep();
		return  nValue <= Integer.MAX_VALUE;
	}

	/**
	 * @param incrmentableValue
	 * @return
	 * 
	 */
	@Override
	public boolean canDecrement() {

		int nValue = getCurrentValue() - getStep();
		return  nValue >= Integer.MIN_VALUE;
	}

	
	
	
	
	/**
	 * 
	 * @return
	 */
	public int getCurrentValue() {
		return mCurrentValue;
	}
	
	/**
	 * 
	 * @param newValue
	 */
	public void setCurrentValue(int newValue) {
		mCurrentValue = newValue;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getStep() {
		return mIncrementStep;
	}
	
	/**
	 * 
	 * @param step
	 */
	public void setStep(int step) {
		mIncrementStep = step;
	}

	
	

	


	

	

}
