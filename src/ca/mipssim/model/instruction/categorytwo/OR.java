/**
 * 
 */
package ca.mipssim.model.instruction.categorytwo;

import java.util.ArrayList;

/**
 * OR(Or) Description : rd <- rs or rt (Page 218)
 * 
 * @author ChouSkim
 * 
 */
public class OR extends CategoryTwo {

	/**
	 * @param binary
	 * @param currentLine
	 */
	public OR(String binary, int currentLine) {
		super(binary, currentLine);
		this.instName = "OR";
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
