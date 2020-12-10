/**
 * InstructionList.java
 * Programmer: Jake Botka
 * Nov 23, 2020
 *
 */
package main.org.botka.utility.api.systems.instructionsexecutor;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * @author Jake Botka
 *
 */
public class InstructionList {

	private List<String> mInstructionList;
	/**
	 *
	 */
	public InstructionList() {
		// TODO Auto-generated constructor stub
	}
	
	
	public List<String> getInstructionList(){
		return this.mInstructionList;
	}


	/**
	 * @param index
	 * @param element
	 * @see java.util.List#add(int, java.lang.Object)
	 */
	public void add(int index, String element) {
		mInstructionList.add(index, element);
	}


	/**
	 * @param e
	 * @return
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean add(String e) {
		return mInstructionList.add(e);
	}


	/**
	 * @param c
	 * @return
	 * @see java.util.List#addAll(java.util.Collection)
	 */
	public boolean addAll(Collection<? extends String> c) {
		return mInstructionList.addAll(c);
	}


	/**
	 * @param index
	 * @param c
	 * @return
	 * @see java.util.List#addAll(int, java.util.Collection)
	 */
	public boolean addAll(int index, Collection<? extends String> c) {
		return mInstructionList.addAll(index, c);
	}


	/**
	 * 
	 * @see java.util.List#clear()
	 */
	public void clear() {
		mInstructionList.clear();
	}


	/**
	 * @param o
	 * @return
	 * @see java.util.List#contains(java.lang.Object)
	 */
	public boolean contains(Object o) {
		return mInstructionList.contains(o);
	}


	/**
	 * @param c
	 * @return
	 * @see java.util.List#containsAll(java.util.Collection)
	 */
	public boolean containsAll(Collection<?> c) {
		return mInstructionList.containsAll(c);
	}


	/**
	 * @param o
	 * @return
	 * @see java.util.List#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		return mInstructionList.equals(o);
	}


	/**
	 * @param action
	 * @see java.lang.Iterable#forEach(java.util.function.Consumer)
	 */
	public void forEach(Consumer<? super String> action) {
		mInstructionList.forEach(action);
	}


	/**
	 * @param index
	 * @return
	 * @see java.util.List#get(int)
	 */
	public String get(int index) {
		return mInstructionList.get(index);
	}


	/**
	 * @return
	 * @see java.util.List#hashCode()
	 */
	public int hashCode() {
		return mInstructionList.hashCode();
	}


	/**
	 * @param o
	 * @return
	 * @see java.util.List#indexOf(java.lang.Object)
	 */
	public int indexOf(Object o) {
		return mInstructionList.indexOf(o);
	}


	/**
	 * @return
	 * @see java.util.List#isEmpty()
	 */
	public boolean isEmpty() {
		return mInstructionList.isEmpty();
	}


	/**
	 * @return
	 * @see java.util.List#iterator()
	 */
	public Iterator<String> iterator() {
		return mInstructionList.iterator();
	}


	/**
	 * @param o
	 * @return
	 * @see java.util.List#lastIndexOf(java.lang.Object)
	 */
	public int lastIndexOf(Object o) {
		return mInstructionList.lastIndexOf(o);
	}


	/**
	 * @return
	 * @see java.util.List#listIterator()
	 */
	public ListIterator<String> listIterator() {
		return mInstructionList.listIterator();
	}


	/**
	 * @param index
	 * @return
	 * @see java.util.List#listIterator(int)
	 */
	public ListIterator<String> listIterator(int index) {
		return mInstructionList.listIterator(index);
	}


	/**
	 * @return
	 * @see java.util.Collection#parallelStream()
	 */
	public Stream<String> parallelStream() {
		return mInstructionList.parallelStream();
	}


	/**
	 * @param index
	 * @return
	 * @see java.util.List#remove(int)
	 */
	public String remove(int index) {
		return mInstructionList.remove(index);
	}


	/**
	 * @param o
	 * @return
	 * @see java.util.List#remove(java.lang.Object)
	 */
	public boolean remove(Object o) {
		return mInstructionList.remove(o);
	}


	/**
	 * @param c
	 * @return
	 * @see java.util.List#removeAll(java.util.Collection)
	 */
	public boolean removeAll(Collection<?> c) {
		return mInstructionList.removeAll(c);
	}


	/**
	 * @param filter
	 * @return
	 * @see java.util.Collection#removeIf(java.util.function.Predicate)
	 */
	public boolean removeIf(Predicate<? super String> filter) {
		return mInstructionList.removeIf(filter);
	}


	/**
	 * @param operator
	 * @see java.util.List#replaceAll(java.util.function.UnaryOperator)
	 */
	public void replaceAll(UnaryOperator<String> operator) {
		mInstructionList.replaceAll(operator);
	}


	/**
	 * @param c
	 * @return
	 * @see java.util.List#retainAll(java.util.Collection)
	 */
	public boolean retainAll(Collection<?> c) {
		return mInstructionList.retainAll(c);
	}


	/**
	 * @param index
	 * @param element
	 * @return
	 * @see java.util.List#set(int, java.lang.Object)
	 */
	public String set(int index, String element) {
		return mInstructionList.set(index, element);
	}


	


	/**
	 * @return
	 * @see java.util.List#size()
	 */
	public int size() {
		return mInstructionList.size();
	}


	/**
	 * @param c
	 * @see java.util.List#sort(java.util.Comparator)
	 */
	public void sort(Comparator<? super String> c) {
		mInstructionList.sort(c);
	}


	/**
	 * @return
	 * @see java.util.List#spliterator()
	 */
	public Spliterator<String> spliterator() {
		return mInstructionList.spliterator();
	}


	/**
	 * @return
	 * @see java.util.Collection#stream()
	 */
	public Stream<String> stream() {
		return mInstructionList.stream();
	}


	/**
	 * @param fromIndex
	 * @param toIndex
	 * @return
	 * @see java.util.List#subList(int, int)
	 */
	public List<String> subList(int fromIndex, int toIndex) {
		return mInstructionList.subList(fromIndex, toIndex);
	}


	/**
	 * @return
	 * @see java.util.List#toArray()
	 */
	public Object[] toArray() {
		return mInstructionList.toArray();
	}


	/**
	 * @param <T>
	 * @param a
	 * @return
	 * @see java.util.List#toArray(java.lang.Object[])
	 */
	public <T> T[] toArray(T[] a) {
		return mInstructionList.toArray(a);
	}
	
	@Override
	public String toString() {
		return "InstructionList [mInstructionList=" + mInstructionList + "]";
	}

}
