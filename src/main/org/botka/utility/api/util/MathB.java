/**
 * MathB.java
 * Programmer: Jake Botka
 * Nov 26, 2020
 *
 */
package main.org.botka.utility.api.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.NonNullByDefault;

import main.org.botka.utility.api.exceptions.IllegalNullArguementException;
import main.org.botka.utility.api.exceptions.NotImplementedYetException;

/**
 * @author Jake Botka
 *
 */
public final class MathB {

	/**
	 *
	 */
	private MathB() {
		// TODO Auto-generated constructor stub
	}

	public static short difference(short x1, short x2) {
		return (short) (x1 - x2);
	}

	public static short difference(short... arr) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr"));
		short difference = 0;
		for (short x : arr) {
			difference = difference(difference, x);
		}
		return difference;
	}

	public static int difference(int x1, int x2) {
		return x1 - x2;
	}

	public static int difference(int... arr) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr"));
		int difference = 0;
		for (int x : arr) {
			difference = difference(difference, x);
		}
		return difference;
	}

	public static long difference(long x1, long x2) {
		return x1 - x2;
	}

	public static long difference(long... arr) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr"));
		long difference = 0;
		for (long x : arr) {
			difference = difference(difference, x);
		}
		return difference;
	}

	public static double difference(double x1, double x2) {
		return x1 - x2;
	}

	public static double difference(double... arr) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr"));
		double difference = 0;
		for (double x : arr) {
			difference = difference(difference, x);
		}
		return difference;
	}

	public static float difference(float x1, float x2) {
		return x1 - x2;
	}

	public static float difference(float... arr) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr"));
		float difference = 0;
		for (float x : arr) {
			difference = difference(difference, x);
		}
		return difference;
	}

	public byte max(byte value1, byte value2) {
		return value1 - value1 >= 0 ? value1 : value2;
	}

	public Byte max(@NonNull Byte value1, @NonNull Byte value2) {
		Util.checkNullArgumentAndThrow(value1, IllegalNullArguementException.formatEceptionMessage("value1"));
		Util.checkNullArgumentAndThrow(value2, IllegalNullArguementException.formatEceptionMessage("value2"));
		return value1.byteValue() - value2.byteValue() >= 0 ? value1 : value2;
	}

	public byte max(@NonNull byte[] arr) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr"));
		byte max = Byte.MIN_VALUE;
		for (byte x : arr) {
			max = max(max,x);
		}
		return max;
	}

	public void max(@NonNull Byte[] arr) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr"));
		throw new NotImplementedYetException();

	}

	public void max(short value1, short value2) {
		throw new NotImplementedYetException();

	}

	public void max(@NonNull Short value1, @NonNull Short value2) {
		throw new NotImplementedYetException();

	}

	public void max(@NonNull short[] arr) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr"));
		throw new NotImplementedYetException();

	}

	public void max(@NonNull Short[] arr) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr"));
		throw new NotImplementedYetException();

	}

	public void max(int value1, int value2) {
		throw new NotImplementedYetException();

	}

	public void max(@NonNull Integer value1, @NonNull Integer value2) {
		throw new NotImplementedYetException();

	}

	public void max(@NonNull int[] arr) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr"));
		throw new NotImplementedYetException();

	}

	public void max(@NonNull Integer[] arr) {
		throw new NotImplementedYetException();

	}

	public void max(long value1, long value2) {
		throw new NotImplementedYetException();

	}

	public void max(@NonNull Long value1, @NonNull Long value2) {
		throw new NotImplementedYetException();

	}

	public void max(@NonNull long[] arr) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr"));
		throw new NotImplementedYetException();

	}

	public void max(@NonNull Long[] arr) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr"));
		throw new NotImplementedYetException();

	}

	public void max(double value1, double value2) {
		throw new NotImplementedYetException();

	}

	public void max(@NonNull Double value1, @NonNull Double value2) {
		throw new NotImplementedYetException();

	}

	public void max(@NonNull double[] arr) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr"));
		throw new NotImplementedYetException();

	}

	public void max(@NonNull Double[] arr) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr"));
		throw new NotImplementedYetException();

	}

	public void max(float value1, float value2) {
		throw new NotImplementedYetException();

	}

	public void max(@NonNull Float value1, float value2) {
		throw new NotImplementedYetException();

	}

	public void max(@NonNull float[] arr) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr"));
		throw new NotImplementedYetException();

	}

	public void max(@NonNull Float[] arr) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr"));
		throw new NotImplementedYetException();

	}

	public void max(@NonNull String value1, @NonNull String value2) {
		throw new NotImplementedYetException();

	}

	public void max(@NonNull String[] arr) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr"));
		throw new NotImplementedYetException();

	}

	public void max(@NonNull Object value1, @NonNull Object value2) {
		
		throw new NotImplementedYetException();

	}

	public void max(@NonNull Object[] arr) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr"));
		throw new NotImplementedYetException();

	}

	public static short sum(short x1, short x2) {
		return (short) (x1 + x2);
	}

	public static short sum(short... arr) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr"));
		short sum = 0;
		for (short x : arr) {
			sum = sum(sum, x);
		}
		return sum;
	}

	public static int sum(int x1, int x2) {
		return x1 + x2;
	}

	public static int sum(int... arr) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr"));
		int sum = 0;
		for (int x : arr) {
			sum = sum(sum, x);
		}
		return sum;
	}

	public static long sum(long x1, long x2) {
		return x1 + x2;
	}

	public static long sum(long... arr) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr"));
		long sum = 0;
		for (long x : arr) {
			sum = sum(sum, x);
		}
		return sum;
	}

	public static double sum(double x1, double x2) {
		return x1 + x2;
	}

	public static double sum(double... arr) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr"));
		double sum = 0;
		for (double x : arr) {
			sum = sum(sum, x);
		}
		return sum;
	}

	public static float sum(float x1, float x2) {
		return x1 + x2;
	}

	public static float sum(float... arr) {
		Util.checkNullArgumentAndThrow(arr, IllegalNullArguementException.formatEceptionMessage("arr"));
		float sum = 0;
		for (float x : arr) {
			sum = sum(sum, x);
		}
		return sum;
	}

	public static String sum(@NonNull String x1, @NonNull String x2) {
		Util.checkNullArgumentAndThrow(x1, IllegalNullArguementException.formatEceptionMessage("x1"));
		Util.checkNullArgumentAndThrow(x2, IllegalNullArguementException.formatEceptionMessage("x2"));
		return x1 + x2;
	}

}
