/*
 * File name:  BufferArray.java
 *
 * Programmer : Jake Botka
 *
 * Date: Aug 19, 2020
 *
 */
package main.org.botka.utility.api.data.structures.arrays;

import java.util.Collection;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;

import main.org.botka.utility.api.exceptions.EmptyBufferException;

/**
 * <insert class description here>
 *
 * @author Jake Botka
 *
 */
public class BufferArray<E> extends Stack<E> {

	private static final long serialVersionUID = -3227118805918307619L;
	private final int DEFAULT_CAP = 10;
	private int mBufferCap;
	private boolean mForcePush;

	/**
	 * Constructor.
	 * 
	 * @param cap Buffer capacity cap
	 */
	public BufferArray(int cap) {
		super();
		this.mBufferCap = cap >= 0 ? cap : DEFAULT_CAP;
	}

	/**
	 * Constructor.
	 * 
	 * @param cap       Buffer capacity cap
	 * @param forcePush Force push and pop when buffer is at capacity
	 */
	public BufferArray(int cap, boolean forcePush) {
		this(cap);
		this.mForcePush = forcePush;
	}

	/**
	 * Pops Element
	 * 
	 * @return Element
	 */
	@Override
	public E pop() {
		if (super.isEmpty() == false)
			return super.pop();
		else
			try {
				throw new EmptyBufferException();
			} catch (EmptyBufferException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public E popNewest() {
		return this.pop();
	}
	
	public E popOldest() {
		if (!super.isEmpty())
			return super.remove(0);
		return null;
	}

	/**
	 * Pushed element to the front of the buffer (top of stack)
	 * 
	 * @param element Element to be pushed
	 * @return Element that was pushed
	 */
	@Override
	public E push(E element) {
		if (this.mForcePush) {
			if (this.isFull())
				this.popOldest();
			return super.push(element);
		} else if (!this.isFull())
			return super.push(element);
		else
			return null;
		// return null;
		
	}

	/**
	 * Adds element to buffer
	 * 
	 * @return True if element was added
	 */
	@Override
	public boolean add(E element) {
		return this.addToBuffer(element);
	}
	
	/**
	 * 
	 */
	@Override
	public void add(int index, E element) {
		if (index < super.size() && index < this.mBufferCap)
			super.add(index, element);
	}
	
	/**
	 * 
	 */
	@Override
	public boolean addAll(Collection<? extends E> c) {
		if (c != null) {
			if (c.size() > 0) {
				Iterator iterator = c.iterator();
				while (iterator.hasNext()) {
					this.add((E)iterator.next());
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Method Not Supported
	 */
	@Deprecated()
	public boolean addAll(int index, Collection<? extends E> c) {
		//TODO
		return false;
	}

	/**
	 * 
	 * @param element
	 * @return
	 */
	public boolean addToBuffer(E element) {
		return this.push(element) != null;
	}

	/**
	 * Grabs the element most recently added to the buffer. The buffer must not be
	 * empty, otherwise it throws exception.
	 * 
	 * @return Element most recently added to buffer
	 * @throws EmptyBufferException
	 */
	public E grabNewest() throws EmptyBufferException {
		if (super.isEmpty() == false)
			return super.pop();
		else
			throw new EmptyBufferException();
		// return null;
	}

	/**
	 * 
	 * @return Element
	 * @throws EmptyBufferException
	 */
	public E grabOldest() throws EmptyBufferException {
		if (!super.isEmpty())
			return super.get(0);
		else
			throw new EmptyBufferException();
	}

	/**
	 * Grabs the most recent element added to the buffer
	 * 
	 * @return Element At the front of the buffer
	 * @throws EmptyBufferException Empty buffer
	 */
	public E grabFront() throws EmptyBufferException {
		return this.grabOldest();
	}

	/**
	 * grabs the most oldest element added to the buffer
	 * 
	 * @return Element
	 * @throws EmptyBufferException Throws if buffer is empty
	 */
	public E grabBack() throws EmptyBufferException {
		return this.grabNewest();
	}

	/**
	 * Checks in element at a certain index of the array is null
	 * 
	 * @param index Index of element
	 * @return True if element is null otherwise false
	 */
	public boolean isNull(int index) {
		if (!super.empty())
			if (index >= 0 && index < this.mBufferCap)
				return super.get(index) == null;
		return false;
	}

	/**
	 * Determines if the buffer is currently full
	 * 
	 * @return True if buffer is full
	 */
	public boolean isFull() {
		return super.size() >= this.mBufferCap;
	}

	/**
	 * Prints buffer to console
	 */
	public void printBuffer() {
		final int size = super.size();
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				String seperator = "";
				if (i + 1 != size)
					seperator = ",";
				System.out.print(String.valueOf(super.get(i)) + seperator);
			}
			System.out.println(); // creates new line
		}
	}

	/**
	 * Constructs a string representation of the buffer and its antributes.
	 * 
	 * @return String representation of this object.
	 */
	public String toString() {
		// TODO
		return super.toString();
	}
}
