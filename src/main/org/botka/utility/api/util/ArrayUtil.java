/*
 * File name:  ArraysUtil.java
 *
 * Programmer : Jake Botka
 * ULID: JMBOTKA
 *
 * Date: Jul 13, 2020
 *
 * Out Of Class Personal Program
 */
package main.org.botka.utility.api.util;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.NonNullByDefault;

import main.org.botka.utility.api.exceptions.IllegalNullArguementException;
import main.org.botka.utility.api.exceptions.NotImplementedYetException;


/**
 * Utility class with static methods pertaining to operations done on the array data structure.
 *
 * @author Jake Botka
 *
 */
public class ArrayUtil {

   public static int[] append(int[] arr, int appendedValue) {
		if (arr != null) {
			int[] newArr = Arrays.copyOf(arr, arr.length + 1);
			newArr[newArr.length - 1] = appendedValue;
		}
		return null;
	}
	
	public static int[] append(int[] arr, int[] appendedValues) {
		if (arr != null && appendedValues != null) {
			int[] newArr = Arrays.copyOf(arr, arr.length + appendedValues.length);
			for (int i = 0; i < appendedValues.length; i++) {
				newArr[i + arr.length] = appendedValues[i];
			}
			return newArr;
		}
		
		return null;
	}
	
	public static  byte[] copy(@NonNull byte[] arr, int amount) {
		return copy(arr,0,amount);
	}
	
	public static  byte[] copy(@NonNull byte[] arr, int offset, int amount) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr, int offset, int amount"));
		byte[] ret = new byte[amount];
		if (offset < 0 || offset + amount >= arr.length) {
			throw new IndexOutOfBoundsException("offset is out of bounds with the array size of " + arr.length);
		}
		int z = 0;
		for (int i = offset; z < amount; i++) {
			ret[z] = arr[i];
			z++;
		}
		return ret;
	}

	public static  Byte[] copy(@NonNull Byte[] arr, int amount) {
		return copy(arr,0,amount);
	}
	
	public static  Byte[] copy(@NonNull Byte[] arr, int offset, int amount) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr, int offset, int amount"));
		throw new NotImplementedYetException();
	}

	public static  short[] copy(@NonNull short[] arr,int amount) {
		return copy(arr,0,amount);
	}
	
	public static  short[] copy(@NonNull short[] arr, int offset, int amount) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr, int offset, int amount"));
		throw new NotImplementedYetException();
	}

	public static  Short[] copy(@NonNull Short[] arr,int amount) {
		return copy(arr,0,amount);
	}

	public static  Short[] copy(@NonNull Short[] arr, int offset, int amount) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr, int offset, int amount"));
		throw new NotImplementedYetException();
	}

	public static  int[] copy(@NonNull int[] arr,int amount) {
		return copy(arr,0,amount);
	}
	
	public static  int[] copy(@NonNull int[] arr, int offset, int amount) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr, int offset, int amount"));
		int[] ret = new int[amount];
		if (offset < 0 || offset + amount >= arr.length) {
			throw new IndexOutOfBoundsException("offset is out of bounds with the array size of " + arr.length);
		}
		int z = 0;
		for (int i = offset; z < amount; i++) {
			ret[z] = arr[i];
			z++;
		}
		return ret;
	}

	public static  Integer[] copy(@NonNull Integer[] arr, int amount) {
		return copy(arr,0,amount);
	}
	
	public static  Integer[] copy(@NonNull Integer[] arr, int offset, int amount) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr, int offset, int amount"));
		throw new NotImplementedYetException();
	}

	public static  long[] copy(@NonNull long[] arr, int amount) {
		return copy(arr,0,amount);
	}
	
	public static  long[] copy(@NonNull long[] arr, int offset, int amount) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr, int offset, int amount"));
		throw new NotImplementedYetException();
	}

	public static  Long[] copy(@NonNull Long[] arr, int amount) {
		return copy(arr,0,amount);
	}
	
	public static  Long[] copy(@NonNull Long[] arr, int offset, int amount) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr, int offset, int amount"));
		throw new NotImplementedYetException();
	}

	public static  double[] copy(@NonNull double[] arr, int amount) {
		return copy(arr,0,amount);
	}
	
	public static  double[] copy(@NonNull double[] arr, int offset, int amount) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr, int offset, int amount"));
		throw new NotImplementedYetException();
	}

	public static  Double[] copy(@NonNull Double[] arr, int amount) {
		return copy(arr,0,amount);
	}
	
	public static  Double[] copy(@NonNull Double[] arr, int offset, int amount) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr, int offset, int amount"));
		throw new NotImplementedYetException();
	}

	public static  float[] copy(@NonNull float[] arr, int amount) {
		return copy(arr,0,amount);
	}
	
	public static  float[] copy(@NonNull float[] arr, int offset, int amount) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr, int offset, int amount"));
		throw new NotImplementedYetException();
	}

	public static  Float[] copy(@NonNull Float[] arr, int amount) {
		return copy(arr,0,amount);
	}
	
	public static  Float[] copy(@NonNull Float[] arr, int offset, int amount) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr, int offset, int amount"));
		throw new NotImplementedYetException();
	}

	public static  String[] copy(@NonNull String[] arr, int amount) {
		return copy(arr,0,amount);
	}
	
	public static  String[] copy(@NonNull String[] arr, int offset, int amount) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr, int offset, int amount"));
		throw new NotImplementedYetException();
	}

	public static  Object[] copy(@NonNull Object[] arr, int amount) {
		return copy(arr,0,amount);
	}
	
	public static  Object[] copy(@NonNull Object[] arr, int offset, int amount) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr, int offset, int amount"));
		throw new NotImplementedYetException();

	}
	
	/**
	 * Combines two arrays.
	 * 
	 * @param arr1 First array
	 * @param arr2 Seccond array
	 * @return Concatted array
	 */
	public static int[] concat(int[] arr1, int[] arr2) {
		int[] arr = null;
		if (arr1 != null && arr2 != null) {
			arr = new int[arr1.length + arr2.length];
			int index = 0;
			for (int i = 0; i < arr1.length; i++) {
				arr[index] = arr1[i];
				index++;
			}

			for (int i = 0; i < arr2.length; i++) {
				arr[index] = arr2[i];
				index++;
			}
		}

		return arr;
	}

	/**
	 * Combines two arrays.
	 * 
	 * @param arr1 First array
	 * @param arr2 Second array
	 * @return concated array
	 */
	public static double[] concat(double[] arr1, double[] arr2) {
		double[] arr = null;
		if (arr1 != null && arr2 != null) {
			arr = new double[arr1.length + arr2.length];
			int index = 0;
			for (int i = 0; i < arr1.length; i++) {
				arr[index] = arr1[i];
				index++;
			}

			for (int i = 0; i < arr2.length; i++) {
				arr[index] = arr2[i];
				index++;
			}
		}

		return arr;
	}

	/**
	 * Combines two arrays.
	 * 
	 * @param arr1 First array
	 * @param arr2 Second array
	 * @return concated array
	 */
	public static float[] concat(float[] arr1, float[] arr2) {
		float[] arr = null;
		if (arr1 != null && arr2 != null) {
			arr = new float[arr1.length + arr2.length];
			int index = 0;
			for (int i = 0; i < arr1.length; i++) {
				arr[index] = arr1[i];
				index++;
			}

			for (int i = 0; i < arr2.length; i++) {
				arr[index] = arr2[i];
				index++;
			}
		}

		return arr;
	}

	/**
	 * Combines two arrays.
	 * 
	 * @param arr1 First array
	 * @param arr2 Second array
	 * @return concated array
	 */
	public static long[] concat(long[] arr1, long[] arr2) {
		long[] arr = null;
		if (arr1 != null && arr2 != null) {
			arr = new long[arr1.length + arr2.length];
			int index = 0;
			for (int i = 0; i < arr1.length; i++) {
				arr[index] = arr1[i];
				index++;
			}

			for (int i = 0; i < arr2.length; i++) {
				arr[index] = arr2[i];
				index++;
			}
		}

		return arr;
	}

	/**
	 * Combines two arrays.
	 * 
	 * @param arr1 First array
	 * @param arr2 Second array
	 * @return concated array
	 */
	public static short[] concat(short[] arr1, short[] arr2) {
		short[] arr = null;
		if (arr1 != null && arr2 != null) {
			arr = new short[arr1.length + arr2.length];
			int index = 0;
			for (int i = 0; i < arr1.length; i++) {
				arr[index] = arr1[i];
				index++;
			}

			for (int i = 0; i < arr2.length; i++) {
				arr[index] = arr2[i];
				index++;
			}
		}

		return arr;
	}

	/**
	 * Combines two arrays.
	 * 
	 * @param arr1 First array
	 * @param arr2 Second array
	 * @return concated array
	 */
	public static Object[] concat(Object[] arr1, Object[] arr2) {
		Object[] arr = null;
		if (arr1 != null && arr2 != null) {
			arr = new Object[arr1.length + arr2.length];
			int index = 0;
			for (int i = 0; i < arr1.length; i++) {
				arr[index] = arr1[i];
				index++;
			}

			for (int i = 0; i < arr2.length; i++) {
				arr[index] = arr2[i];
				index++;
			}
		}

		return arr;
	}

	public Byte[] convertToWrapperArray(@NonNull byte[] arr) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr"));
		Byte[] newArr = null;
		newArr = new Byte[arr.length];

		for (int i = 0; i < arr.length; i++) {
			newArr[i] = new Byte(arr[i]);
		}
		return newArr;

	}

	public Short[] convertToWrapperArray(@NonNull short[] arr) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr"));
		Short[] newArr = null;
		newArr = new Short[arr.length];

		for (int i = 0; i < arr.length; i++) {
			newArr[i] = new Short(arr[i]);
		}
		return newArr;

	}

	/**
	 * 
	 * @param primitive array
	 * @return Array of Integer Objects
	 */
	public static Integer[] converToWrapperArray(@NonNull int[] arr) {
		if (arr != null) {
			Integer[] newArr = null;
			newArr = new Integer[arr.length];

			for (int i = 0; i < arr.length; i++) {
				newArr[i] = new Integer(arr[i]);
			}

			return newArr;
		}

		return null;
	}

	public Long[] convertToWrapperArray(@NonNull long[] arr) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr"));
		Long[] newArr = null;
		newArr = new Long[arr.length];

		for (int i = 0; i < arr.length; i++) {
			newArr[i] = new Long(arr[i]);
		}
		return newArr;

	}

	/**
	 * 
	 * @param primitive array
	 * @return Array of Double Objects
	 */
	public static Double[] converToWrapperArray(double[] arr) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr"));
		Double[] newArr = null;
		newArr = new Double[arr.length];

		for (int i = 0; i < arr.length; i++) {
			newArr[i] = new Double(arr[i]);
		}
		return newArr;
	
	}

	public Float[] convertToWrapperArray(@NonNull float[] arr) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr"));
		Float[] newArr = null;
		newArr = new Float[arr.length];

		for (int i = 0; i < arr.length; i++) {
			newArr[i] = new Float(arr[i]);
		}
		return newArr;
	}

	/**
	 * Shallow clones the array
	 * 
	 * @param arr Input Array
	 * @return Deep cloned array
	 */
	public static byte[] clone(byte[] arr) {
		if (arr != null) {
			byte[] clone = new byte[arr.length];
			for (int i = 0; i < clone.length; i++) {
				clone[i] = arr[i];
			}

			return clone;
		}
		return arr;
	}

	/**
	 * Shallow clones the array
	 * 
	 * @param arr Input Array
	 * @return Deep cloned array
	 */
	public static short[] clone(short[] arr) {
		if (arr != null) {
			short[] clone = new short[arr.length];
			for (int i = 0; i < clone.length; i++) {
				clone[i] = arr[i];
			}

			return clone;
		}
		return arr;
	}

	/**
	 * Shallow clones the array
	 * 
	 * @param arr Input Array
	 * @return Deep cloned array
	 */
	public static int[] clone(int[] arr) {
		if (arr != null) {
			int[] clone = new int[arr.length];
			for (int i = 0; i < clone.length; i++) {
				clone[i] = arr[i];
			}

			return clone;
		}
		return arr;
	}

	/**
	 * Shallow clones the array
	 * 
	 * @param arr Input Array
	 * @return Deep cloned array
	 */
	public static long[] clone(long[] arr) {
		if (arr != null) {
			long[] clone = new long[arr.length];
			for (int i = 0; i < clone.length; i++) {
				clone[i] = arr[i];
			}

			return clone;
		}
		return arr;
	}

	/**
	 * Shallow clones the array
	 * 
	 * @param arr Input Array
	 * @return Deep cloned array
	 */
	public static double[] clone(double[] arr) {
		if (arr != null) {
			double[] clone = new double[arr.length];
			for (int i = 0; i < clone.length; i++) {
				clone[i] = arr[i];
			}

			return clone;
		}
		return arr;
	}

	/**
	 * Shallow clones the array
	 * 
	 * @param arr Input Array
	 * @return Deep cloned array
	 */
	public static float[] clone(float[] arr) {
		if (arr != null) {
			float[] clone = new float[arr.length];
			for (int i = 0; i < clone.length; i++) {
				clone[i] = arr[i];
			}

			return clone;
		}
		return arr;
	}

	/**
	 * Deep clones the array
	 * 
	 * @param arr Input Array
	 * @return Deep cloned array
	 */
	public static String[] clone(String[] arr) {
		if (arr != null) {
			String[] clone = new String[arr.length];
			for (int i = 0; i < clone.length; i++) {
				clone[i] = arr[i];
			}

			return clone;
		}
		return arr;
	}

	/**
	 * Deep clones the array
	 * 
	 * @param arr Input Array
	 * @return Deep cloned array
	 */
	public static Object[] clone(Object[] arr) {
		if (arr != null) {
			Object[] clone = new Object[arr.length];
			for (int i = 0; i < clone.length; i++) {
				clone[i] = arr[i];
			}

			return clone;
		}
		return arr;
	}

	/**
	 * Flips the order of the array.
	 * 
	 * @param arr Input array
	 */
	public static void flip(byte[] arr) {
		if (arr != null) {
			byte[] temp = clone(arr);
			for (int i = 0; i < arr.length; i++) {
				arr[i] = temp[arr.length - 1 - i];
			}
		}
	}

	/**
	 * Flips the order of the array.
	 * 
	 * @param arr Input array
	 */
	public static void flip(int[] arr) {
		if (arr != null) {
			int[] temp = clone(arr);
			for (int i = 0; i < arr.length; i++) {
				arr[i] = temp[arr.length - 1 - i];
			}
		}
	}

	/**
	 * Flips the order of the array.
	 * 
	 * @param arr Input array
	 */
	public static void flip(double[] arr) {
		if (arr != null) {
			double[] temp = clone(arr);
			for (int i = 0; i < arr.length; i++) {
				arr[i] = temp[arr.length - 1 - i];
			}
		}
	}

	/**
	 * Flips the order of the array.
	 * 
	 * @param arr Input array
	 */
	public static void flip(float[] arr) {
		if (arr != null) {
			float[] temp = clone(arr);
			for (int i = 0; i < arr.length; i++) {
				arr[i] = temp[arr.length - 1 - i];
			}
		}
	}

	/**
	 * Flips the order of the array.
	 * 
	 * @param arr Input array
	 */
	public static void flip(long[] arr) {
		if (arr != null) {
			long[] temp = clone(arr);
			for (int i = 0; i < arr.length; i++) {
				arr[i] = temp[arr.length - 1 - i];
			}
		}
	}

	/**
	 * Flips the order of the array.
	 * 
	 * @param arr Input array
	 */
	public static void flip(short[] arr) {
		if (arr != null) {
			short[] temp = clone(arr);
			for (int i = 0; i < arr.length; i++) {
				arr[i] = temp[arr.length - 1 - i];
			}
		}
	}

	/**
	 * Flips the order of the array.
	 * 
	 * @param arr Input array
	 */
	public static void flip(String[] arr) {
		if (arr != null) {
			String[] temp = clone(arr);
			for (int i = 0; i < arr.length; i++) {
				arr[i] = temp[arr.length - 1 - i];
			}
		}
	}

	/**
	 * Flips the order of the array.
	 * 
	 * @param arr Input array
	 */
	public static void flip(Object[] arr) {
		if (arr != null) {
			Object[] temp = clone(arr);
			for (int i = 0; i < arr.length; i++) {
				arr[i] = temp[arr.length - 1 - i];
			}
		}
	}

	/**
	 * Must implement a equals method in objects class. Returns the index of
	 * specified object in the params of array and the value that is being searched
	 * 
	 * @param arr
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> int indexOf(T[] arr, T value) {

		for (int i = 0; i < arr.length; i++) {

			if (arr[i].equals(value)) {
				return i;
			}

		}
		return -1;
	}

	/**
	 * 
	 * @param arr
	 */
	public static void print(@NonNull Object[] arr) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr"));
		int index = 0;
		System.out.println("Elements of array");
		for (Object obj : arr) {
			System.out.println("Element " + index + ": " + String.valueOf(arr.toString()));
			index++;
		}
	}

	/**
	 * 
	 * @param arr
	 */
	public static void print(@NonNull String[] arr) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr"));
		int index = 0;
		System.out.println("Elements of array");
		for (String obj : arr) {
			System.out.println("Element " + index + ": " + String.valueOf(obj));
			index++;
		}
	}

	/**
	 * 
	 */
	public static void print(int[] arr) {
		System.out.println(ArrayUtil.toString(arr));
	}

	/**
	 * 
	 */
	public static void print(double[] arr) {
		System.out.println(ArrayUtil.toString(arr));
	}

	/**
	 * Flattens a 2d array into a one demential array using object type paramaters
	 * that can be utilized to any object generic type
	 * 
	 * @param arr
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] flattenArray(T[][] arr) {

		Object[] x = new Object[arr.length * arr[0].length];
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int z = 0; z < arr[0].length; z++) {
				x[index] = arr[i][z];
				index++;
			}
		}
		return (T[]) x;

	}

	/**
	 * Allows objects to be sorted as long as they extend Comparable
	 * 
	 * @param arr
	 * @return
	 */
	public static <T extends Comparable<T>> T findMaxinArray(T[] arr) {
		T max = null;
		if (arr != null) {
			for (int i = 0; i < arr.length; i++) {
				if (i == 0) {
					max = arr[i];
				} else {
					if (arr[i].compareTo(max) > 0) {
						max = arr[i];
					}
				}

			}
		}
		return max;
	}

	/**
	 * 
	 * @param arr
	 * @return
	 */
	public static int findMaxInArray(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = arr[i] > max ? arr[i] : max;
		}
		return max;
	}

	/**
	 * 
	 * @param arr
	 * @return
	 */
	public static long findMaxInArray(long[] arr) {
		long max = Long.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = arr[i] > max ? arr[i] : max;
		}
		return max;
	}

	/**
	 * 
	 * @param arr
	 * @return
	 */
	public static double findMaxInArray(double[] arr) {
		double max = Double.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = arr[i] > max ? arr[i] : max;
		}
		return max;
	}

	/**
	 * Moves element from one position to another
	 * 
	 * @param arr          The array
	 * @param index        Index to be moved
	 * @param newIndex     New index location
	 * @param defaultValue Value to replace ol index
	 * @return true if the element was moved otherwise false due to possible errors
	 *         such as indexes not in bounds of the array
	 */
	public static boolean moveElementTo(int[] arr, int index, int newIndex, int defaultValue) {
		if (arr != null) {
			if (index >= 0 && index < arr.length && newIndex >= 0 && newIndex < arr.length) {
				arr[newIndex] = arr[index];
				arr[index] = defaultValue;
				return true;
			}
		}

		return false;
	}

	/**
	 * Moves element from one position to another
	 * 
	 * @param arr          The array
	 * @param index        Index to be moved
	 * @param newIndex     New index location
	 * @param defaultValue Value to replace ol index
	 * @return true if the element was moved otherwise false due to possible errors
	 *         such as indexes not in bounds of the array
	 */
	public static boolean moveElementTo(double[] arr, int index, int newIndex, double defaultValue) {
		if (arr != null) {
			if (index >= 0 && index < arr.length && newIndex >= 0 && newIndex < arr.length) {
				arr[newIndex] = arr[index];
				arr[index] = defaultValue;
				return true;
			}
		}

		return false;
	}

	/**
	 * Moves element from one position to another
	 * 
	 * @param arr          The array
	 * @param index        Index to be moved
	 * @param newIndex     New index location
	 * @param defaultValue Value to replace ol index
	 * @return true if the element was moved otherwise false due to possible errors
	 *         such as indexes not in bounds of the array
	 */
	public static boolean moveElementTo(long[] arr, int index, int newIndex, long defaultValue) {
		if (arr != null) {
			if (index >= 0 && index < arr.length && newIndex >= 0 && newIndex < arr.length) {
				arr[newIndex] = arr[index];
				arr[index] = defaultValue;
				return true;
			}
		}

		return false;
	}

	/**
	 * Moves element from one position to another
	 * 
	 * @param arr          The array
	 * @param index        Index to be moved
	 * @param newIndex     New index location
	 * @param defaultValue Value to replace ol index
	 * @return true if the element was moved otherwise false due to possible errors
	 *         such as indexes not in bounds of the array
	 */
	public static boolean moveElementTo(float[] arr, int index, int newIndex, float defaultValue) {
		if (arr != null) {
			if (index >= 0 && index < arr.length && newIndex >= 0 && newIndex < arr.length) {
				arr[newIndex] = arr[index];
				arr[index] = defaultValue;
				return true;
			}
		}

		return false;
	}

	/**
	 * Moves element from one position to another
	 * 
	 * @param arr          The array
	 * @param index        Index to be moved
	 * @param newIndex     New index location
	 * @param defaultValue Value to replace ol index
	 * @return true if the element was moved otherwise false due to possible errors
	 *         such as indexes not in bounds of the array
	 */
	public static boolean moveElementTo(Object[] arr, int index, int newIndex) {
		if (arr != null) {
			if (index >= 0 && index < arr.length && newIndex >= 0 && newIndex < arr.length) {
				arr[newIndex] = arr[index];
				arr[index] = null;
				return true;
			}
		}

		return false;
	}

	/**
	 * Moves element from one position to another
	 * 
	 * @param arr          The array
	 * @param index        Index to be moved
	 * @param newIndex     New index location
	 * @param defaultValue Value to replace to index
	 * @return true if the element was moved otherwise false due to possible errors
	 *         such as indexes not in bounds of the array
	 */
	public static <T> boolean moveElementTo(T[] arr, int index, int newIndex, T defaultValue) {
		if (arr != null) {
			if (index >= 0 && index < arr.length && newIndex >= 0 && newIndex < arr.length) {
				arr[newIndex] = arr[index];
				arr[index] = defaultValue;
				return true;
			}
		}

		return false;
	}

	/**
	 * Trims the array to a new size based off of the value to be trimed
	 * 
	 * @param arr          The array
	 * @param trimValue Value to trim off of array
	 * @return
	 */
	public static String[] trim(String[] arr, String trimValue) {
		if (arr != null) {
			String[] arrNew = null;
			String indexes = "";

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != trimValue) {
					indexes += String.valueOf(i);
				}
			}

			arrNew = new String[indexes.length()];
			for (int i = 0; i < arrNew.length; i++) {
				arrNew[i] = arr[indexes.charAt(i)];
			}
			return arrNew;
		}
		return arr;
	}

	/**
	 * Trims the array to a new size based off of the value to be trimed
	 * 
	 * @param arr          The array
	 * @param trimValue Value to trim off of array
	 * @return
	 */
	public static int[] trim(int[] arr, int trimValue) {
		if (arr != null) {
			int[] arrNew = null;
			String indexes = "";

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != trimValue) {
					indexes += String.valueOf(i);
				}
			}

			arrNew = new int[indexes.length()];
			for (int i = 0; i < arrNew.length; i++) {
				arrNew[i] = arr[indexes.charAt(i)];
			}
			return arrNew;
		}
		return arr;
	}

	/**
	 * Trims the array to a new size based off of the value to be trimed
	 * 
	 * @param arr          The array
	 * @param trimValue Value to trim off of array
	 * @return
	 */
	public static double[] trim(double[] arr, double trimValue) {
		if (arr != null) {
			double[] arrNew = null;
			String indexes = "";

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != trimValue) {
					indexes += String.valueOf(i);
				}
			}

			arrNew = new double[indexes.length()];
			for (int i = 0; i < arrNew.length; i++) {
				arrNew[i] = arr[indexes.charAt(i)];
			}
			return arrNew;
		}
		return arr;
	}

	/**
	 * Trims the array to a new size based off of the value to be trimed
	 * 
	 * @param arr          The array
	 * @param trimValue Value to trim off of array
	 * @return
	 */
	public static float[] trim(float[] arr, float trimValue) {
		if (arr != null) {
			float[] arrNew = null;
			String indexes = "";

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != trimValue) {
					indexes += String.valueOf(i);
				}
			}

			arrNew = new float[indexes.length()];
			for (int i = 0; i < arrNew.length; i++) {
				arrNew[i] = arr[indexes.charAt(i)];
			}
			return arrNew;
		}
		return arr;
	}

	/**
	 * Trims the array to a new size based off of the value to be trimed
	 * 
	 * @param arr          The array
	 * @param trimValue Value to trim off of array
	 * @return
	 */
	public static long[] trim(long[] arr, double trimValue) {
		if (arr != null) {
			long[] arrNew = null;
			String indexes = "";

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != trimValue) {
					indexes += String.valueOf(i);
				}
			}

			arrNew = new long[indexes.length()];
			for (int i = 0; i < arrNew.length; i++) {
				arrNew[i] = arr[indexes.charAt(i)];
			}
			return arrNew;
		}
		return arr;
	}

	/**
	 * Trims the array to a new size based off of the value to be trimed
	 * 
	 * @param arr          The array
	 * @param trimValue Value to trim off of array
	 * @return Trimmed Array
	 */
	public static short[] trim(short[] arr, double trimValue) {
		if (arr != null) {
			short[] arrNew = null;
			String indexes = "";

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != trimValue) {
					indexes += String.valueOf(i);
				}
			}

			arrNew = new short[indexes.length()];
			for (int i = 0; i < arrNew.length; i++) {
				arrNew[i] = arr[indexes.charAt(i)];
			}
			return arrNew;
		}
		return arr;
	}

	/**
	 * Trims the array to a new size based off of the value to be trimed
	 * 
	 * @param arr          The array
	 * @param trimValue Value to trim off of array
	 * @return
	 */
	public static byte[] trim(byte[] arr, byte trimValue) {
		if (arr != null) {
			byte[] arrNew = null;
			String indexes = "";

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != trimValue) {
					indexes += String.valueOf(i);
				}
			}

			arrNew = new byte[indexes.length()];
			for (int i = 0; i < arrNew.length; i++) {
				arrNew[i] = arr[indexes.charAt(i)];
			}
			return arrNew;
		}
		return arr;
	}

	/**
	 * Trims the array by trimming all null values
	 * 
	 * @param arr The array
	 * @return Trimmed array
	 */
	public static Object[] trim(Object[] arr) {
		if (arr != null) {
			Object[] arrNew = null;
			String indexes = "";

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != null) {
					indexes += String.valueOf(i);
				}
			}

			arrNew = new Object[indexes.length()];
			for (int i = 0; i < arrNew.length; i++) {
				arrNew[i] = indexes.charAt(i);
			}
			return arrNew;
		}
		return arr;
	}

	/**
	 * Trims the array to a new size based off of the value to be trimed
	 * 
	 * @param arr          The array
	 * @param trimValue Value to trim off of array
	 * @return Trimmed array
	 */
	public static Object[] trim(Object[] arr, Object trimValue) {
		if (arr != null) {
			Object[] arrNew = null;
			String indexes = "";

			for (int i = 0; i < arr.length; i++) {
				if (!arr[i].equals(trimValue)) {
					indexes += String.valueOf(i);
				}
			}

			arrNew = new Object[indexes.length()];
			for (int i = 0; i < arrNew.length; i++) {
				arrNew[i] = indexes.charAt(i);
			}
			return arrNew;
		}
		return arr;
	}

	// TODO: Add other primitive versions

	/**
	 * 
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int[] fillArray(int[] arr, int value) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = value;
		}

		return arr;
	}

	// TODO: Add other primitive versions
	/**
	 * Extracts string representation of the array and its elements
	 * 
	 * @param arr Input array
	 * @return String representation of array
	 */
	public static String toString(Object[] arr) {
		String x = "";
		if (arr != null) {
			for (int i = 0; i < arr.length; i++) {
				// if not the last then execute first statement but if is then execute last
				// statement and assign
				x += i != arr.length - 1 ? String.valueOf(arr[i].toString() + ",") : String.valueOf(arr[i].toString());
			}
			return x;
		}
		return String.valueOf("null");
	}

	/**
	 * Extracts string representation of the array and its elements
	 * 
	 * @param arr Input array
	 * @return String representation of array
	 */
	public static String toString(String[] arr) {
		String x = "";
		if (arr != null) {
			for (int i = 0; i < arr.length; i++) {
				// if not the last then execute first statement but if is then execute last
				// statement and assign
				x += i != arr.length - 1 ? String.valueOf(arr[i] + ",") : String.valueOf(arr[i]);
			}
			return x;
		}
		return String.valueOf("null");
	}

	/**
	 * Extracts string representation of the array and its elements
	 * 
	 * @param arr Input array
	 * @return String representation of array
	 */
	public static String toString(int[] arr) {
		String x = "";
		if (arr != null) {
			for (int i = 0; i < arr.length; i++) {
				// if not the last then execute first statement but if is then execute last
				// statement and assign
				x += i != arr.length - 1 ? String.valueOf(arr[i] + ",") : String.valueOf(arr[i]);

			}

			return x;
		}
		return String.valueOf("null");
	}

	/**
	 * Extracts string representation of the array and its elements
	 * 
	 * @param arr Input array
	 * @return String representation of array
	 */
	public static String toString(double[] arr) {
		String x = "";
		if (arr != null) {
			for (int i = 0; i < arr.length; i++) {
				x += i != arr.length - 1 ? String.valueOf(arr[i] + ",") : String.valueOf(arr[i]);
			}

			return x;
		}
		return String.valueOf("null");
	}

	/**
	 * 
	 * @param arr
	 * @return
	 */
	public static String toString(int[][] arr) {
		String x = "";
		if (arr != null) {
			for (int i = 0; i < arr.length; i++) {
				for (int z = 0; z < arr[i].length; z++) {
					x += String.valueOf(arr[i] + ",");
				}

				x += "\n";
			}
			return x;
		}
		return String.valueOf("null");
	}

	/////// TODO

	/**
	 * Rotates array clockwise
	 * 
	 * @param arr
	 */
	public static void rotate90(int[] arr) {
  
	}

	/////// TO OVERLOAD

	/**
	 * 
	 * @param size
	 * @return
	 */
	public static int[] resize(int[] arr, int newSize) {
		if (arr != null && newSize >= 0) {
			int[] nArr = new int[newSize];
			for (int i = 0; i < newSize; i++) {
				nArr[i] = arr[i];
			}

			return nArr;
		}
		return null;

	}

	/**
	 * Create a list of integers filled with values that are incremented form zero
	 * to the range - 1 (inclusive)
	 * 
	 * @param range INclusive cap for list
	 * @return array of Integers
	 */
	public static int[] arrange(int range) {
		return arrange(0, range);
	}

	/**
	 * Create a list of integers filled with values that are incremented from A
	 * starting value to the ending value - 1 (inclusive)
	 * 
	 * @param startRange The value that the increment starts at
	 * @param endRange   The value that the increment ends at - 1
	 * @return array of Integers filled with ordered values that are between the
	 *         start range and end range
	 */
	public static int[] arrange(int startRange, int endRange) {
		return arrange(startRange, endRange, 1);
	}

	/**
	 * 
	 * @param startRange The value that the increment starts at
	 * @param endRange   The value that the increment ends at - 1
	 * @param step       The Value to be incremented by each increasing index
	 * @return array of Integers filled with ordered values that are between the
	 *         start range and end range
	 */
	public static int[] arrange(int startRange, int endRange, int step) {
		endRange -= 1; // inclusive
		startRange -= step;
		int rounds = (int) Math.floor((endRange - startRange) / step);
		int[] arr = null;
		arr = new int[rounds];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = startRange += step;
		}
		return arr;
	}

}
