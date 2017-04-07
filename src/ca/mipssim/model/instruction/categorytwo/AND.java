/**
 * 
 */
package ca.mipssim.model.instruction.categorytwo;

import java.util.ArrayList;

/**
 * AND(And) Description : rd <- rs AND rt (Page 42)
 * 
 * @author ChouSkim
 * 
 */
public class AND extends CategoryTwo {

	/**
	 * @param binary
	 * @param currentLine
	 */
	public AND(String binary, int currentLine) {
		super(binary, currentLine);
		this.instName = "AND";
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
