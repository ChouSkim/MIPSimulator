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

	// List of machine code.
	ArrayList machineCodeList = null;
	// List of instruction.
	ArrayList instructionList = null;
	// List of data.
	ArrayList dataList = null;

	// The address begins at 128.
	int currentLine = 128;
	// The start of data address.
	int DC;
	// 
	boolean DCAssigned = false;

	// Indicate whether BREAK has appeared or not.
	public static boolean breakAppeared = false;

	/**
	 * @param machineCodeList
	 *            Lines of machine code in the source file.
	 */
	public Disassembler(ArrayList machineCodeList) {
		this.machineCodeList = machineCodeList;
		this.instructionList = new ArrayList();
		this.dataList = new ArrayList();
	}

	/**
	 * Run the disassembler and get the result.
	 * 
	 * @see ca.mipssim.component.IExecutable#run()
	 */
	public String run() {
		StringBuilder result = new StringBuilder();

		for (Iterator iterator = this.machineCodeList.iterator(); iterator
				.hasNext();) {
			this.getFrame(result, iterator);
		}

		return result.toString();
	}

	/**
	 * Get a frame in the given format : The disassembler output file should
	 * contain 3 columns of data with each column separated by one tab
	 * character('\t').<BR/>
	 * 
	 * Note, if you are displaying an instruction, the third column should
	 * contain every part of the instruction, with each argument separated by a
	 * comma and then a space(",").
	 * 
	 * @param result
	 *            The StringBuilder to append the result by step.
	 * @param iterator
	 *            Iterator to get machine code in Disassembler.machineCodeList.
	 */
	private void getFrame(StringBuilder result, Iterator iterator) {
		String binary = (String) iterator.next();

		// Add first column : the text string representing the 32-bit data
		// word.
		result.append(binary + "\t");

		// Add Second column : the address (in decimal) of that location.
		result.append(String.valueOf(currentLine) + "\t");

		if (!breakAppeared) {
			// Parse instructions according to binary text. (Simple Factory
			// Pattern)
			AbstractInstruction instruction = BinaryFactory.parseInstruction(
					binary, currentLine);

			// Add Third column : the disassembled instruction.
			result.append(instruction.parse());

			// Add the instruction to list, which will be accessed by Simulator.
			this.instructionList.add(instruction);
		} else {
			// Record the Start address of data for Simulator.
			if (!DCAssigned) {
				this.DC = currentLine;
				DCAssigned = true;
			}

			// Parse data according to binary text. (Simple Factory Pattern)
			AbstractData data = BinaryFactory.parseData(binary, currentLine);

			// Add Third column : the disassembled data.
			result.append(data.calculate());

			// Add the data to list, which will be accessed by Simulator.
			this.dataList.add(data);
		}
		result.append("\r\n");

		// Update the number of current line.
		currentLine = currentLine + 4;
	}
}
