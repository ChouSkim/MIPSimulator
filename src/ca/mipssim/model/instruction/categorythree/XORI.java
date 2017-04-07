/**
 * 
 */
package ca.mipssim.model.instruction.categorythree;

import java.util.ArrayList;

/**
 * @author ChouSkim
 * 
 */
public class XORI extends CategoryThree {

	/**
	 * @param binary
	 * @param currentLine
	 */
	public XORI(String binary, int currentLine) {
		super(binary, currentLine);
		this.instName = "XORI";
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
