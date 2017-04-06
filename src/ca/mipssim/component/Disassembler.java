package ca.mipssim.component;

import java.util.ArrayList;

/**
 * @author ChouSkim
 * 
 */
public class Disassembler implements Executable {

	ArrayList machineCode = null;

	/**
	 * @param machineCode
	 *            Lines of machine code in the source file.
	 */
	public Disassembler(ArrayList machineCode) {
		this.machineCode = machineCode;
	}

	/**
	 * Run the disassembler and get the result.
	 * 
	 * @see ca.mipssim.component.Executable#run()
	 */
	public String run() {
		String result = "disassembly";

		return result;
	}

}
