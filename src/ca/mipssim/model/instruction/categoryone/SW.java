/**
 * 
 */
package ca.mipssim.model.instruction.categoryone;

/**
 * SW(Store Word) Description: memory[base+offset] <- rt. (Page 270)
 * 
 * @author ChouSkim
 * 
 */
public class SW extends CategoryOne {

	int base;
	int rt;
	int offset;

	/**
	 * @param binary
	 * @param currentLine
	 */
	public SW(String binary, int currentLine) {
		super(binary, currentLine);
		this.instName = "SW";

		base = Integer.valueOf(machineCode.substring(6, 11), 2).intValue();
		rt = Integer.valueOf(machineCode.substring(11, 16), 2).intValue();
		offset = Integer.valueOf(machineCode.substring(16, 32), 2).intValue();
	}

	/**
	 * Format : SW rt, offset(base)
	 */
	public String parse() {
		return this.instName + " R" + this.rt + ", " + this.offset + "(R"
				+ this.base + ")";

	}
}
