/**
 * 
 */
package ca.mipssim.model.instruction.categoryone;

import java.util.ArrayList;

/**
 * J(Jump) Description: This is a PC-region branch (not PC-relative); the
 * effective target address is in the ¡°current¡± 256 MB-aligned region. The low
 * 28 bits of the target address is the instr_index field shifted left 2 bits.
 * The remaining upper bits are the corresponding bits of the address of the
 * instruction in the delay slot (not the branch itself). Jump to the effective
 * target address. Execute the instruction that follows the jump, in the branch
 * delay slot, before executing the jump itself. (Page 138)
 * 
 * @author ChouSkim
 * 
 */
public class J extends CategoryOne {

	int instr_index;

	/**
	 * 
	 * @param binary
	 * @param currentLine
	 */
	public J(String binary, int currentLine) {
		super(binary, currentLine);
		this.instName = "J";

		instr_index = Integer.valueOf(machineCode.substring(6, 32) + "00", 2)
				.intValue();
	}

	/**
	 * Format : J target
	 */
	public String parse() {
		this.assemblyCode = this.instName + " #"
				+ String.valueOf(this.instr_index);
		return this.assemblyCode;
	}

	/**
	 * PC <- PC_{GPRLEN-1...28} || instr_index || 0^2
	 * 
	 * @see ca.mipssim.model.instruction.AbstractInstruction#execute(java.util.ArrayList
	 *      , java.util.ArrayList, int)
	 */
	public int execute(ArrayList registerList, ArrayList dataList, int PC,
			final int dataStart) {
		return this.instr_index - 4;
	}
}
