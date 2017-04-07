/**
 * 
 */
package ca.mipssim.model.instruction.categorythree;

import ca.mipssim.model.instruction.AbstractInstruction;

/**
 * @author ChouSkim
 * 
 */
public abstract class CategoryThree extends AbstractInstruction {

	protected int rs;
	protected int rt;
	protected int immediate;

	/**
	 * 
	 */
	public CategoryThree(String binary, int currentLine) {
		super(binary, currentLine);
		this.opcode = binary.substring(13, 16);

		this.rs = Integer.valueOf(machineCode.substring(3, 8), 2).intValue();
		this.rt = Integer.valueOf(machineCode.substring(8, 13), 2).intValue();
		this.immediate = Integer.valueOf(machineCode.substring(16, 32), 2)
				.intValue();
	}

	/**
	 * Format : Opcode rt, rs, immediate
	 * 
	 * @see ca.mipssim.model.IBinary#parse(java.lang.String)
	 */
	public String parse() {
		this.assemblyCode = this.instName + " R" + this.rt + ", R" + this.rs
				+ ", #" + this.immediate;
		return this.assemblyCode;
	}

}
