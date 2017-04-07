/**
 * 
 */
package ca.mipssim.model.instruction;

import java.util.ArrayList;

import ca.mipssim.model.AbstractBinary;

/**
 * @author ChouSkim
 * 
 */
public abstract class AbstractInstruction extends AbstractBinary {

	// Opcode in 3-bit binary
	protected String opcode;
	// Opcode in text
	protected String instName;
	// The string of assembly code.
	protected String assemblyCode;

	/**
	 * @param currentLine
	 */
	public AbstractInstruction(String machineCode, int currentLine) {
		super(machineCode, currentLine);
		this.opcode = "";
		this.instName = "";
		this.assemblyCode = "";
	}

	/**
	 * Each instruction can be parsed into assembly code.
	 * 
	 * @return Assembly code.
	 */
	public abstract String parse();

	/**
	 * 
	 * Each instruction can execute and get a result.
	 * 
	 * @param registerList
	 * @param dataList
	 * @param PC
	 * @param dataStart
	 */
	public abstract int execute(ArrayList registerList, ArrayList dataList,
			int PC, final int dataStart);

	public String getOpcode() {
		return this.opcode;
	}

	public String getInstructionName() {
		return this.instName;
	}

	public String getAssemblyCode() {
		return this.assemblyCode;
	}
}
