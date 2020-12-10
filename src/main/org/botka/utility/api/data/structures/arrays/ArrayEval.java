/*
 * File name:  ArrayEval.java
 *
 * Programmer : Jake Botka
 *
 * Date: Aug 17, 2020
 *
 */
package main.org.botka.utility.api.data.structures.arrays;

/**
 * Utility class for array evaluations
 *
 * @author Jake Botka
 *
 */
public class ArrayEval {

	/**
	 * 
	 * @param arr
	 * @return
	 */
	public static double mean(double[] arr) {
		double answer = Double.NaN;
		if (arr != null) {
			double sum = 0.0;
			for (double d : arr) {
				sum += d;
			}

			answer = sum / (double) arr.length;
		}
		return answer;
	}

	/**
	 * 
	 * @param arr
	 * @return
	 */
	public static double min(double[] arr) {
		double min = Double.MIN_VALUE;
		return min;
	}

	/**
	 * 
	 * @param arr
	 * @return
	 */
	public static double max(double[] arr) {
		double max = Double.MAX_VALUE;
		return max;
	}
	
	/**
	 * 
	 * @param arr
	 * @param value
	 * @return
	 */
	public boolean hasValue(Object[] arr, Object value) {
		if (arr != null && value != null)
			for (int i =0; i < arr.length; i++)
				if (arr[i].equals(value))
					return true;
		return false;
	}

	/**
	 * 
	 * @param arr
	 * @return
	 */
	public static boolean hasNull(Object[] arr) {
		if (arr != null)
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == null)
					return true;
			}
		return false;
	}

}
