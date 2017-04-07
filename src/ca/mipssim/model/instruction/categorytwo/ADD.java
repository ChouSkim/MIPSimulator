/**
 * 
 */
package ca.mipssim.model.instruction.categorytwo;

import java.util.ArrayList;

/**
 * ADD(Add Word) Description : rd <- rs + rt. (Page 34)
 * 
 * @author ChouSkim
 * 
 */
public class ADD extends CategoryTwo {

	/**
	 * @param binary
	 * @param currentLine
	 */
	public ADD(String binary, int currentLine) {
		super(binary, currentLine);
		this.instName = "ADD";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ca.mipssim.model.instruction.AbstractInstruction#execute(java.util.ArrayList
	 * , java.util.ArrayList, int, int)
	 */
	public int execute(ArrayList registerList, ArrayList dataList, int PC,
			int dataStart) {
		System.out.println("ADD");
		int source = ((Integer) registerList.get(this.rs)).intValue();
		int target = ((Integer) registerList.get(this.rt)).intValue();

		registerList.set(this.rd, Integer.valueOf(source + target));

		return PC;
	}
}
