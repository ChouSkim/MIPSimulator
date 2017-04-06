/**
 * 
 */
package ca.mipssim.model.instruction.categoryone;

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
		return this.instName + " #" + String.valueOf(this.instr_index);
	}
}
