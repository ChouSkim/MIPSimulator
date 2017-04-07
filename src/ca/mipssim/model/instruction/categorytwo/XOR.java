/**
 * 
 */
package ca.mipssim.model.instruction.categorytwo;

import java.util.ArrayList;

/**
 * XOR(Exclusive OR) Description : rd <- rs XOR rt. (Page 313)
 * 
 * @author ChouSkim
 * 
 */
public class XOR extends CategoryTwo {

	/**
	 * @param binary
	 * @param currentLine
	 */
	public XOR(String binary, int currentLine) {
		super(binary, currentLine);
		this.instName = "XOR";
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
