/**
 * 
 */
package ca.mipssim.model.instruction.categoryone;

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
		return this.instName + " R" + this.rs + ", #" + this.offset;

	}
}
