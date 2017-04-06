/**
 * 
 */
package ca.mipssim.model.instruction.categoryone;

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
		return this.instName + " R" + this.rs + ", R" + this.rt + ", #"
				+ this.offset;
	}
}
