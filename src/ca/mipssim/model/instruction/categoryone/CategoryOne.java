/**
 * 
 */
package ca.mipssim.model.instruction.categoryone;

import ca.mipssim.model.instruction.AbstractInstruction;

/**
 * @author ChouSkim
 * 
 */
public class CategoryOne extends AbstractInstruction {

	/**
	 * 
	 * @param binary
	 * @param currentLine
	 */
	public CategoryOne(String binary, int currentLine) {
		super(binary, currentLine);
		this.opcode = binary.substring(3, 6);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.mipssim.model.instruction.IInstruction#parse(java.lang.String)
	 */
	public String parse() {
		// TODO Auto-generated method stub
		return "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.mipssim.model.instruction.IInstruction#getOpcode()
	 */
	public String getOpcode() {
		// TODO Auto-generated method stub
		return opcode;
	}

}
