/**
 * Instruction.java
 * Programmer: Jake Botka
 * Nov 23, 2020
 *
 */
package main.org.botka.utility.api.systems.instructionsexecutor;

import java.lang.reflect.Method;
import java.util.Arrays;

import main.org.botka.utility.api.util.ClassUtil;

/**
 * Class represents a instruction that can invoke a method
 * @author Jake Botka
 *
 */
public abstract class Instruction {

	private Class<?> mClass;
	private Object mObject;
	
	
	/**
	 *
	 */
	private  Instruction() {
		this.mClass = null;
		this.mObject = null;
		
	}
	
	
	
	/**
	 *@param mClass
	 *@param mObject
	 *@param mMethod
	 *@param mMethodParams
	 */
	public Instruction(Class<?> classObj, Object object) {
		super();
		this.mClass = classObj;
		this.mObject = object;
		
	}



	public abstract Object executeInstruction();
	
	

	



	/**
	 * @param mClass the mClass to set
	 */
	public void setClass(Class<?> classObj) {
		this.mClass = classObj;
	}



	/**
	 * @return the mObject
	 */
	public Object getObject() {
		return mObject;
	}



	/**
	 * @param mObject the mObject to set
	 */
	public void setObject(Object object) {
		this.mObject = object;
	}






	@Override
	public String toString() {
		return "Instruction [mClass=" + mClass + ", mObject=" + mObject  + "]";
	}

}
