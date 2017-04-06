/**
 * 
 */
package ca.mipssim.model.instruction.categoryone;

/**
 * LW(Load Word) Description: rt <- memory[base+offset]. (Page 161)
 * 
 * @author ChouSkim
 * 
 */
public class LW extends CategoryOne {

	int base;
	int rt;
	int offset;

	/**
	 * @param binary
	 * @param currentLine
	 */
	public LW(String binary, int currentLine) {
		super(binary, currentLine);
		this.instName = "LW";

		base = Integer.valueOf(machineCode.substring(6, 11), 2).intValue();
		rt = Integer.valueOf(machineCode.substring(11, 16), 2).intValue();
		// Note: no sign-extend here.
		offset = Integer.valueOf(machineCode.substring(16, 32), 2).intValue();
	}

	/**
	 * Format : LW rt, offset(base)
	 */
	public String parse() {
		return this.instName + " R" + this.rt + ", " + this.offset + "(R"
				+ this.base + ")";

	}
}
