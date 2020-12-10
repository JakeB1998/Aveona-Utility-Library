/**
 * DataContainer.java
 * Programmer: Jake Botka
 * Nov 9, 2020
 *
 */
package main.org.botka.utility.api.data;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Vector;

import org.eclipse.jdt.annotation.NonNull;

/**
 * @author Jake Botka
 *
 */
public class DataContainer<T> extends LinkedList<T> {

	private Vector<T> mContainer;
	
	public DataContainer() {
		super();
		this.mContainer = new Vector<>();
		
	}
	
	public void addItem(T item) {
		this.mContainer.add(item);
	}
	
	public int size() {
		return this.mContainer.size();
	}

	/**
	 * @return the mContainer
	 */
	public Vector<T> getContainer() {
		return mContainer;
	}

	/**
	 * @param mContainer the mContainer to set
	 */
	public void setContainer(@ NonNull Vector<T> container) {
		if (container == null) {
			throw new NullPointerException();
		}
		this.mContainer = container;
	}

	@Override
	public String toString() {
		return "DataContainer [mContainer=" + mContainer + ", size=" + this.size() + ", first=" + this.mContainer.get(0) + ", last=" + this.mContainer.get(this.size() - 1)
				+ ", modCount=" + modCount + ", getContainer()=" + getContainer() + ", getFirst()=" + getFirst()
				+ ", getLast()=" + getLast() + ", removeFirst()=" + removeFirst() + ", removeLast()=" + removeLast()
				+ ", size()=" + size() + ", peek()=" + peek() + ", element()=" + element() + ", poll()=" + poll()
				+ ", remove()=" + remove() + ", peekFirst()=" + peekFirst() + ", peekLast()=" + peekLast()
				+ ", pollFirst()=" + pollFirst() + ", pollLast()=" + pollLast() + ", pop()=" + pop()
				+ ", descendingIterator()=" + descendingIterator() + ", toArray()=" + Arrays.toString(toArray())
				+ ", spliterator()=" + spliterator() + ", iterator()=" + iterator() + ", listIterator()="
				+ listIterator() + ", hashCode()=" + hashCode() + ", isEmpty()=" + isEmpty() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + "]";
	}
	
	
}
