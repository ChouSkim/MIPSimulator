/**
 * 
 */
package ca.mipssim.model.instruction.categorythree;

import java.util.ArrayList;

/**
 * ADDI(Add Immediate Word) Description : rt <- rs + immediate. (Page 36)
 * 
 * @author ChouSkim
 * 
 */
public class ADDI extends CategoryThree {

	/**
	 * @param binary
	 * @param currentLine
	 */
	public ADDI(String binary, int currentLine) {
		super(binary, currentLine);
		this.instName = "ADDI";
	}

	/**
	 * temp <- (GPR[rs]_{31} || GPR[rs]_{31...0}) + sign_extend(immediate)<BR/>
	 * GPR[rt] <- temp
	 * 
	 * @see ca.mipssim.model.instruction.AbstractInstruction#execute(java.util.ArrayList
	 *      , java.util.ArrayList, int, int)
	 */
	public int execute(ArrayList registerList, ArrayList dataList, int PC,
			int dataStart) {
		int result = ((Integer) registerList.get(this.rs)).intValue()
				+ this.immediate;
		registerList.set(this.rt, Integer.valueOf(result));

		return PC;
	}
}
