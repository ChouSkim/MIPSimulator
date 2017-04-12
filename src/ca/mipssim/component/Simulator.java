/**
 * 
 */
package ca.mipssim.component;

import java.util.ArrayList;

import ca.mipssim.model.data.AbstractData;
import ca.mipssim.model.instruction.AbstractInstruction;

/**
 * @author ChouSkim
 * 
 */
public class Simulator implements IExecutable {

	// List of instruction.
	ArrayList instructionList = null;
	// List of data.
	ArrayList dataList = null;

	// 
	ArrayList registerList = null;

	// The cycle begins at 1.
	int currentCycle = 1;
	// The Program Counter's address begins at 128
	int PC = 128;
	// The Data Counter's address depends on the result of Disassembler.
	int DC;
	// The Data Counter's start address.
	final int dataStart;

	/**
	 * @param disassembler
	 */
	public Simulator(Disassembler disassembler) {
		this.instructionList = disassembler.instructionList;
		this.dataList = disassembler.dataList;
		this.dataStart = this.DC = disassembler.DC;

		this.registerList = new ArrayList();
		for (int i = 0; i < 32; i++) {
			registerList.add(new Integer("0"));
		}
	}

	/**
	 * Run the simulator and get the result.
	 * 
	 * @see ca.mipssim.component.IExecutable#run()
	 */
	public String run() {
		StringBuilder result = new StringBuilder();

		// Fetch the first instruction.
		AbstractInstruction instruction = this.getInstructionAtPC(PC);
		while (!instruction.getInstructionName().equals("BREAK")) {
			// TODO Execute the instruction.
			PC = instruction.execute(registerList, dataList, PC, dataStart);

			// Get the frame for one cycle.
			this.getFrame(result, instruction);

			// Update the PC and curentCycle.
			PC = PC + 4;
			currentCycle = currentCycle + 1;
			// Fetch next instruction.
			instruction = getInstructionAtPC(PC);
		}
		PC = instruction.execute(registerList, dataList, PC, dataStart);
		this.getFrame(result, instruction);

		return result.toString();
	}

	/**
	 * TODO Add format information
	 * 
	 * @param result
	 * @param instruction
	 */
	private void getFrame(StringBuilder result, AbstractInstruction instruction) {
		result.append("--------------------"
				+ System.getProperty("line.separator"));
		result.append("Cycle:" + this.currentCycle + "\t"
				+ instruction.getLineNumber() + "\t"
				+ instruction.getAssemblyCode()
				+ System.getProperty("line.separator"));

		this.printRegistersBlock(result);
		this.printDataBlock(result);

		result.append(System.getProperty("line.separator"));
	}

	/**
	 * TODO Add format information
	 * 
	 * @param result
	 */
	private void printRegistersBlock(StringBuilder result) {
		result.append(System.getProperty("line.separator") + "Resigters");
		result.append(System.getProperty("line.separator") + "R00:");
		for (int i = 0; i < 8; i++)
			result.append("\t" + registerList.get(i));
		result.append(System.getProperty("line.separator") + "R08:");
		for (int i = 8; i < 16; i++)
			result.append("\t" + registerList.get(i));
		result.append(System.getProperty("line.separator") + "R16:");
		for (int i = 16; i < 24; i++)
			result.append("\t" + registerList.get(i));
		result.append(System.getProperty("line.separator") + "R24:");
		for (int i = 24; i < 32; i++)
			result.append("\t" + registerList.get(i));
	}

	/**
	 * @param result
	 */
	private void printDataBlock(StringBuilder result) {
		DC = dataStart;
		// How much data is to be output.
		int dataLeft = dataList.size();
		// How much data has been printed.
		int dataPrinted = 0;

		result.append(System.getProperty("line.separator")
				+ System.getProperty("line.separator") + "Data"
				+ System.getProperty("line.separator"));
		while (dataLeft / 8 > 0) {
			result.append(DC + ":");
			for (int i = 0; i < 8; i++) {
				result.append("\t"
						+ ((AbstractData) dataList.get(i + dataPrinted))
								.getData());
			}
			result.append(System.getProperty("line.separator"));

			//
			dataPrinted = dataPrinted + 8;
			// 
			dataLeft = dataLeft - 8;
			// Update DC
			DC = DC + 32;
		}

		if (dataLeft > 0) {
			// There is data not output.
			result.append(DC + ":");
			for (int i = 0; i < dataLeft; i++) {
				result.append("\t" + dataList.get(i + dataPrinted));
			}
			result.append(System.getProperty("line.separator"));
		}
	}

	/**
	 * @param PC
	 * @return
	 */
	private AbstractInstruction getInstructionAtPC(int PC) {
		return ((AbstractInstruction) this.instructionList.get(PC / 4 - 32));
	}
}
