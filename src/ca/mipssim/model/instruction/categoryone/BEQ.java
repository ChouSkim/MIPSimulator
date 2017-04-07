/**
 * 
 */
package ca.mipssim.model.instruction.categoryone;

import java.util.ArrayList;

/**
 * BEQ(Branch on EQual) Description: if rs = rt then branch. (Page 60).
 * 
 * @author ChouSkim
 * 
 */
public class BEQ extends CategoryOne {

	int rs;
	int rt;
	int offset;

	/**
	 * 
	 * @param binary
	 * @param currentLine
	 */
	public BEQ(String binary, int currentLine) {
		super(binary, currentLine);
		this.instName = "BEQ";

		rs = Integer.valueOf(machineCode.substring(6, 11), 2).intValue();
		rt = Integer.valueOf(machineCode.substring(11, 16), 2).intValue();
		offset = Integer.valueOf(machineCode.substring(16, 32) + "00", 2)
				.intValue();
	}

	/**
	 * Format : BEQ rs, rt, offset
	 */
	public String parse() {
		this.assemblyCode = this.instName + " R" + this.rs + ", R" + this.rt
				+ ", #" + this.offset;
		return this.assemblyCode;
	}

	/**
	 * target_offset <- sign_extend (offset || 0^2) <BR/>
	 * condition <- (GPR[rs] = GPR[rt])<BR/>
	 * <BR/>
	 * if (condition) then <BR/>
	 * &nbsp;&nbsp;&nbsp;&nbsp;PC<-PC+target_offset<BR/>
	 * endif
	 * 
	 * @see ca.mipssim.model.instruction.AbstractInstruction#execute(java.util.ArrayList
	 *      , java.util.ArrayList, int)
	 */
	public int execute(ArrayList registerList, ArrayList dataList, int PC,
			final int dataStart) {
		System.out.println("BEQ");
		int source = ((Integer) registerList.get(this.rs)).intValue();
		int target = ((Integer) registerList.get(this.rt)).intValue();

		if (source == target)
			PC = PC + this.offset;

		return PC;
	}
}
