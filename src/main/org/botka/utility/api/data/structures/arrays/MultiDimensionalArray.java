/*
 * File name:  MultiDimensionalArray.java
 *
 * Programmer : Jake Botka
 *
 * Date: Sep 4, 2020
 *
 */
package main.org.botka.utility.api.data.structures.arrays;

import java.util.Vector;

import org.eclipse.jdt.annotation.NonNull;

/**
 * <insert class description here>
 *
 * @author Jake Botka
 *
 */
public class MultiDimensionalArray<T> {

	private Object[] mCellVector;
	private int[] mShape;
	private int mCellCount;
	private int[] mShapeOffset;
	/**
	 * 
	 */
	public MultiDimensionalArray() {
		this.mCellVector = null;
		this.mShape = null;
		this.mCellCount = 0;
		this.mShapeOffset = null;
	}
	
	public MultiDimensionalArray(@NonNull int[] shape) {
		this();
		this.mShape = shape;
		if (shape != null) {
			int number = Integer.MIN_VALUE;
			this.mShapeOffset = new int[shape.length];
			if (shape.length > 0) {
				this.mCellCount = 1;
				for (int i =0; i < shape.length; i++) {
					this.mCellCount *= shape[i];
					this.mShapeOffset[i] = shape[i] - 1;
					if (shape[i] <= 0) {
						throw new RuntimeException("Can not have a dimension less than or equal to zero, dimmension inserted: " 
								+ shape[i]);
					}
				}
			}
		}
		this.mCellVector = new Object[this.mCellCount];
	}
	
	public void fillWith(T value) {
		for (int i = 0; i < this.mCellVector.length; i++) {
			this.mCellVector[i] = value;
		}
	}
	
	public boolean addAt(@NonNull int[] indices, T value) {
		if (indices == null) {
			throw new NullPointerException();
		}
		int index = translateIndecesToVectorIndex(indices);
		if (index >= 0 && index < this.mCellVector.length) {
			this.mCellVector[index] = value;
			return true;
		}
			return false;
		
	}
	
	private int translateIndecesToVectorIndex(@NonNull int[] indices) {
		int findingIndex = -1;
		if (indices != null && this.mCellVector.length > 0) {
			 findingIndex = 0;
			for (int i =0; i < indices.length; i++) {
				int index = indices[i];
				if (index >= 0 && index <= this.mShapeOffset[i]) {
					findingIndex += this.mShapeOffset[i] * indices[i];
				}
				else {
					throw new IndexOutOfBoundsException("At dimension: " + this.mShape[i] + ". "
							+ index + "against a dimension length of " + this.mShape[i]);
				}
			}
			return findingIndex;
		}
		else {
			
			if (indices == null) {
				throw new NullPointerException();
			}
			
			throw new IndexOutOfBoundsException("THe length of array: " + this.mCellVector.length);
		}
		
	}
	/**
	 * 
	 * @param index The indexs of that represent the dimensions of where the item is located/
	 * @return
	 */
	public T getItem(int[] indices) {
		int findingIndex = -1;
		findingIndex = translateIndecesToVectorIndex(indices);
		
		return findingIndex >= 0 ? (T)this.mCellVector[findingIndex] : null;
	}
	
	/**
	 * 
	 * @return
	 */
	public int[] getShape() {
		return this.mShape;
	}
	
	

}
