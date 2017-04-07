/**
 * 
 */
package ca.mipssim.model.instruction.categorythree;

import java.util.ArrayList;

/**
 * @author ChouSkim
 * 
 */
public class ORI extends CategoryThree {

	/**
	 * @param binary
	 * @param currentLine
	 */
	public ORI(String binary, int currentLine) {
		super(binary, currentLine);
		this.instName = "ORI";
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
		// TODO Unimplemented.
		return PC;
	}
}
