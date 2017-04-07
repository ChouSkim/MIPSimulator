/**
 * 
 */
package ca.mipssim.model.instruction.categoryone;

import java.util.ArrayList;

/**
 * BGTZ(Branch on Greater Than Zero) Description: if rs > 0 then branch. (Page
 * 69)
 * 
 * @author ChouSkim
 * 
 */
public class BGTZ extends CategoryOne {

	int rs;
	int offset;

	/**
	 * @param binary
	 * @param currentLine
	 */
	public BGTZ(String binary, int currentLine) {
		super(binary, currentLine);
		this.instName = "BGTZ";

		rs = Integer.valueOf(machineCode.substring(6, 11), 2).intValue();
		offset = Integer.valueOf(machineCode.substring(16, 32) + "00", 2)
				.intValue();
	}

	/**
	 * Format : BGTZ rs, offset
	 */
	public String parse() {
		this.assemblyCode = this.instName + " R" + this.rs + ", #"
				+ this.offset;
		return this.assemblyCode;
	}

	/**
	 * target_offset <- sign_extend (offset || 0^2) <BR/>
	 * condition <- GPR[rs] > 0^{GPRLEN}<BR/>
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
		System.out.println("BGTZ");
		int source = ((Integer) registerList.get(this.rs)).intValue();

		if (source > 0)
			PC = PC + this.offset;
		return PC;
	}
}
