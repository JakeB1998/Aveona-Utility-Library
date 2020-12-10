/**
 * ListUtil.java
 * Programmer: Jake Botka
 * Nov 4, 2020
 *
 */
package main.org.botka.utility.api.util;

import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Utility class for lists. This class has operations that can be performed on and/or with list data structures.
 * 
 * @author Jake Botka
 *
 */
public final class ListUtil {

	/**
	 * Checks if all elements in the list are the same. 
	 * Both list do not have to be ordered the same as long as both list have the same elements.Otherwise it will return false
	 * @param list1 List 1
	 * @param list2 List 2
	 * @return True if both list contains equal element unordered. Otherwise returns false.
	 *
	 */
	public static boolean containsSameElements(@NonNull List<?> list1, @NonNull List<?> list2) {
		if (list1 != null && list2 != null) {
			//enter code here
		}
		return false;
	}
	
	/**
	 * Checks if all elements in both list are equal to eachother in order.
	 * That means if both list have the same elements but are ordered differently then it will return false.
	 * @param list1 List 1
	 * @param list2 List 2
	 * @return True if both list contains equal elements in order. Otherwise returns false.
	 *
	 */
	public static boolean containsSameElementsInOrder(@NonNull List<?> list1, @NonNull List<?> list2) {
		if (list1 != null && list2 != null) {
			if (list1.size() != list2.size()) {
				return false;
			}
			
			boolean flag = false;
			Iterator<?> containerIterator = list1.iterator();
			Iterator<?> containerSnapshotIterator = list2.iterator();
			while (containerIterator.hasNext() && containerSnapshotIterator.hasNext()) {
				if (!containerIterator.next().equals(containerSnapshotIterator.next())) {
					flag = true;
					break;
				}
			}
			return !flag;
		}
		return false;
	}

	/**
	 * Safe removes element form list at a particular index position.
	 * 
     * @param <T> Type of list.
	 * @param list List.
	 * @param index Index position of element to be removed.
	 * @return Removed element.
	 *
	 */
	@SuppressWarnings("unchecked")
	public static <T> T safeRemove(@NonNull List<T> list, int index){
		Util.checkNullAndThrow(list);
		if(isInBounds(list, index)) {
			Iterator<T> iterator = list.iterator();
			int indexPosition = 0;
			while (iterator.hasNext()) {
				Object e = iterator.next();
				if (indexPosition == index) {
					iterator.remove();
					return (T) e;
				}
				indexPosition++;
			}
		}
		return null;
		
	}
	/**
	 * Safely removes all elements from a list. 
	 * This is thread safe and avoids the concurrent modification exception.
	 * 
	 * @param <T> Type of list.
	 * @param list List.
	 *
	 */
	public static <T> void safeRemoveAll(@NonNull List<T> list) {
		Util.checkNullAndThrow(list);
		Iterator<T> iterator = list.iterator();
		while(iterator.hasNext()) {
			iterator.next();
			iterator.remove();
		}
	}
	
	
	public static <T> boolean isInBounds(@NonNull List<T> list, int index) {
		Util.checkNullAndThrow(list);
		int size = list.size();
		if (index >= 0 && index < size) {
			return true;
		}
		return false;
	}
	
	

}
