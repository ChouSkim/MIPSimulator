/**
 * 
 */
package ca.mipssim.model.instruction.categorytwo;

import ca.mipssim.model.instruction.AbstractInstruction;

/**
 * @author ChouSkim
 * 
 */
public abstract class CategoryTwo extends AbstractInstruction {

	protected int rs;
	protected int rt;
	protected int rd;

	/**
	 * 
	 */
	public CategoryTwo(String binary, int currentLine) {
		super(binary, currentLine);
		this.opcode = binary.substring(13, 16);

		this.rs = Integer.valueOf(machineCode.substring(3, 8), 2).intValue();
		this.rt = Integer.valueOf(machineCode.substring(8, 13), 2).intValue();
		this.rd = Integer.valueOf(machineCode.substring(16, 21), 2).intValue();
	}

	/**
	 * Format : Opcode rd, rs, rt
	 * 
	 * @see ca.mipssim.model.IBinary#parse(java.lang.String)
	 */
	public String parse() {
		this.assemblyCode = this.instName + " R" + this.rd + ", R" + this.rs
				+ ", R" + this.rt;
		return this.assemblyCode;
	}

}
