/**
 * MethodInstruction.java
 * Programmer: Jake Botka
 * Nov 23, 2020
 *
 */
package main.org.botka.utility.api.systems.instructionsexecutor;

import java.lang.reflect.Method;

import main.org.botka.utility.api.util.ClassUtil;

/**
 * @author Jake Botka
 *
 */
public class MethodInstruction extends Instruction {

	private Method mMethod;
	private Object[] mMethodParams;
	/**
	 *@param classObj
	 *@param object
	 *@param method
	 *@param methodParams
	 */
	public MethodInstruction(Class<?> classObj, Object object, Method method, Object[] methodParams) {
		super(classObj, object);
		this.mMethod = method;
		this.mMethodParams = methodParams;
		
	}
	
	private Object invokeMethod() {
		return ClassUtil.invokeMethod(super.getObject(), this.mMethod, this.mMethodParams);
	}

	@Override
	public Object executeInstruction() {
		// TODO Auto-generated method stub
		return null;
	}



	/**
	 * @return the mMethod
	 */
	public Method getMethod() {
		return mMethod;
	}



	/**
	 * @param mMethod the mMethod to set
	 */
	public void setMethod(Method method) {
		this.mMethod = method;
	}



	/**
	 * @return the mMethodParams
	 */
	public Object[] getMethodParams() {
		return mMethodParams;
	}



	/**
	 * @param mMethodParams the mMethodParams to set
	 */
	public void setmMethodParams(Object[] methodParams) {
		this.mMethodParams = methodParams;
	}
	

}
