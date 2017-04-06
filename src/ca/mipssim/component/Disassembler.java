package ca.mipssim.component;

import java.util.ArrayList;
import java.util.Iterator;

import ca.mipssim.model.BinaryFactory;
import ca.mipssim.model.data.AbstractData;
import ca.mipssim.model.instruction.AbstractInstruction;

/**
 * @author ChouSkim
 * 
 */
public class Disassembler implements IExecutable {

	// List of machine code
	ArrayList machineCodeList = null;
	// List of assembleCode
	ArrayList assembleCode = null;

	// The Address begins at 128.
	int currentLine = 128;

	// Indicate whether BREAK has appeared.
	public static boolean breakAppeared = false;

	/**
	 * @param machineCodeList
	 *            Lines of machine code in the source file.
	 */
	public Disassembler(ArrayList machineCodeList) {
		this.machineCodeList = machineCodeList;
	}

	/**
	 * Run the disassembler and get the result.
	 * 
	 * @see ca.mipssim.component.IExecutable#run()
	 */
	public String run() {
		StringBuilder result = new StringBuilder();

		for (Iterator iterator = machineCodeList.iterator(); iterator.hasNext();) {
			String binary = (String) iterator.next();

			// Add first column : the text string representing the 32-bit data
			// word.
			result.append(binary + "\t");

			// Add Second column : the address (in decimal) of that location.
			result.append(String.valueOf(currentLine) + "\t");
			currentLine = currentLine + 4;

			if (!breakAppeared) {
				AbstractInstruction instruction = BinaryFactory
						.parseInstruction(binary, currentLine);

				// Add Third column : the disassembled instruction.
				result.append(instruction.parse());
			} else {
				AbstractData data = BinaryFactory.parseData(binary);
			}
			result.append("\r\n");
		}

		return result.toString();
	}
}
