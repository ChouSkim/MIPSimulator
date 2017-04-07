/**
 * 
 */
package ca.mipssim.model.instruction.categorytwo;

import java.util.ArrayList;

/**
 * NOR(Not Or) Description : rd <- rs NOR rt
 * 
 * @author ChouSkim
 * 
 */
public class NOR extends CategoryTwo {

	/**
	 * @param binary
	 * @param currentLine
	 */
	public NOR(String binary, int currentLine) {
		super(binary, currentLine);
		this.instName = "NOR";
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
		// TODO Auto-generated method stub

		return PC;
	}

}
