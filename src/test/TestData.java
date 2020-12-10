/**
 * TestData.java
 * Programmer: Jake Botka
 * Oct 29, 2020
 *
 */
package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jake Botka
 *
 */
public class TestData {

	public static final double[] DOUBLE_DATA_SMALL_SIZE = {43,235.3,2342.1,543.5,543.1,25,59,34,67.5,12.232};
	
	public static int[] INTEGER_DATA_SMALL_SIZE = {1,10,4,100,65,0,-1,45,61,34,-22};
	
	public static String[] STRING_DATA_MEDIUM_SIZE = {"hi", "BYE", null, "NULL", "", "apples", "ddsfer322"};
	
	public static final ArrayList<String> STRING_ARRAYLIST_MEDIUM_SIZE = new ArrayList<>(Arrays.asList(STRING_DATA_MEDIUM_SIZE));
	

}
