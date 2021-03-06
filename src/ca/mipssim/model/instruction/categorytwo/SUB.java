/**
 * 
 */
package ca.mipssim.model.instruction.categorytwo;

import java.util.ArrayList;

/**
 * SUB(Substract Word) Description : rd <- rs - rt. (Page 266)
 * 
 * @author ChouSkim
 * 
 */
public class SUB extends CategoryTwo {

	/**
	 * @param binary
	 * @param currentLine
	 */
	public SUB(String binary, int currentLine) {
		super(binary, currentLine);
		this.instName = "SUB";
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
		int source = ((Integer) registerList.get(this.rs)).intValue();
		int target = ((Integer) registerList.get(this.rt)).intValue();

		registerList.set(this.rd, Integer.valueOf(source - target));

		return PC;
	}

}
