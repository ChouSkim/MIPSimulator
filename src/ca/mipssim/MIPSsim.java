package ca.mipssim;

import java.util.ArrayList;

import ca.mipssim.component.Disassembler;
import ca.mipssim.component.Simulator;

/**
 * 
 */

/**
 * Project One of Computer Architecture. On my honor, I have neither given nor
 * received unauthorized aid on this assignment.
 * 
 * @author ChouSkim
 * 
 */
public class MIPSsim {

	static ArrayList machineCode = new ArrayList();
	static String disassemblyResult = "disassembly";
	static String simulationResult = "simulation";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Read file given by commandline.
		machineCode = FileIOUtils.inputStringFromFile(args[0]);

		// Disassemble.
		Disassembler disassembler = new Disassembler(machineCode);
		disassemblyResult = disassembler.run();

		// Simulate.
		Simulator simulator = new Simulator(disassembler);
		simulationResult = simulator.run();

		// Write result to "disassembly.txt" and "simulation.txt"
		FileIOUtils.writeStringToFile(disassemblyResult, "disassembly.txt");
		FileIOUtils.writeStringToFile(simulationResult, "simulation.txt");

	}
}
