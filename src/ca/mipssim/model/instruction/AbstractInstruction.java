/**
 * 
 */
package ca.mipssim.model.instruction;

import ca.mipssim.model.AbstractBinary;

/**
 * @author ChouSkim
 * 
 */
public abstract class AbstractInstruction extends AbstractBinary {

	protected String opcode;
	protected String instName;

	/**
	 * @param currentLine
	 */
	public AbstractInstruction(String machineCode, int currentLine) {
		super(machineCode, currentLine);
		this.opcode = "";
		this.instName = "";
	}

	/**
	 * Each instruction can be parsed into assembly code.
	 * 
	 * @return Assembly code.
	 */
	public abstract String parse();

	public abstract String getOpcode();
}
