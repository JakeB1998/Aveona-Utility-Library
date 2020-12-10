/**
 * InstructionExecutor.java
 * Programmer: Jake Botka
 * Nov 23, 2020
 *
 */
package main.org.botka.utility.api.systems.instructionsexecutor;

import org.eclipse.jdt.annotation.NonNull;

/**
 * 
 * Executor that executes a set of instructions. 
 * an example of This being utilized is by reading in instruction sets from file such as those of listing graphic rendering calls in file to be eecuted at runtime.
 * @author Jake Botka
 *
 */
public class InstructionExecutor {

	/**
	 *
	 */
	public InstructionExecutor() {
		
	}
	
	public Object[] executeInstructions(@NonNull InstructionList list) {
		return executeInstructions(list.getInstructionList().toArray( new Instruction[0]));
	}
	
	public Object[] executeInstructions(@NonNull Instruction[] instructions) {
		//check nulls
		Object[] returnResults = null;
		returnResults = new Object[instructions.length];
		for (int i =0; i < returnResults.length; i++) {
			Instruction instruction = instructions[i];
			returnResults[i] = instruction != null ? instruction.executeInstruction() : null;
		}
		return returnResults;
	}

}
