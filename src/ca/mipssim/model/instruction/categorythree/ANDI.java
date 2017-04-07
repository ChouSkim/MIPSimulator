/**
 * 
 */
package ca.mipssim.model.instruction.categorythree;

import java.util.ArrayList;

/**
 * @author ChouSkim
 * 
 */
public class ANDI extends CategoryThree {

	/**
	 * @param binary
	 * @param currentLine
	 */
	public ANDI(String binary, int currentLine) {
		super(binary, currentLine);
		this.instName = "ANDI";
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
		// TODO Test. (symbol & may not work. )
		int result = ((Integer) registerList.get(this.rs)).intValue()
				& this.immediate;
		registerList.set(this.rt, Integer.valueOf(result));

		return PC;
	}
}
