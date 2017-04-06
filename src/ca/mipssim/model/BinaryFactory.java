/**
 * 
 */
package ca.mipssim.model;

import ca.mipssim.component.Disassembler;
import ca.mipssim.model.data.AbstractData;
import ca.mipssim.model.data.Integer.SignedInteger;
import ca.mipssim.model.instruction.AbstractInstruction;
import ca.mipssim.model.instruction.categoryone.BEQ;
import ca.mipssim.model.instruction.categoryone.BGTZ;
import ca.mipssim.model.instruction.categoryone.BREAK;
import ca.mipssim.model.instruction.categoryone.J;
import ca.mipssim.model.instruction.categoryone.LW;
import ca.mipssim.model.instruction.categoryone.SW;
import ca.mipssim.model.instruction.categorythree.ADDI;
import ca.mipssim.model.instruction.categorythree.ANDI;
import ca.mipssim.model.instruction.categorythree.ORI;
import ca.mipssim.model.instruction.categorythree.XORI;
import ca.mipssim.model.instruction.categorytwo.ADD;
import ca.mipssim.model.instruction.categorytwo.AND;
import ca.mipssim.model.instruction.categorytwo.MUL;
import ca.mipssim.model.instruction.categorytwo.NOR;
import ca.mipssim.model.instruction.categorytwo.OR;
import ca.mipssim.model.instruction.categorytwo.SUB;
import ca.mipssim.model.instruction.categorytwo.XOR;

/**
 * A Simple Factory for create instructions and data according to the binary
 * text.
 * 
 * @author ChouSkim
 * 
 */
public class BinaryFactory {

	/**
	 * @param binary
	 * @param currentLine
	 * @return
	 */
	public static AbstractInstruction parseInstruction(String binary,
			int currentLine) {
		AbstractInstruction result = null;

		// TODO Change Four function into one.
		switch (BinaryFactory.getLeftMostThree(binary)) {
		case 0:
			// Category One Instruction.
			switch (BinaryFactory.getOpcodeForCategoryOne(binary)) {
			case 0:
				result = new J(binary, currentLine);
				break;
			case 2:
				result = new BEQ(binary, currentLine);
				break;
			case 4:
				result = new BGTZ(binary, currentLine);
				break;
			case 5:
				result = new BREAK(binary, currentLine);
				// If instruction BREAK appears, set the flag true.
				Disassembler.breakAppeared = true;
				break;
			case 6:
				result = new SW(binary, currentLine);
				break;
			case 7:
				result = new LW(binary, currentLine);
				break;
			default:
				// TODO Throw UnknownInstruction Exception.
				System.out.println("default");
				break;
			}
			break;
		case 6:
			// Category Two Instruction.
			switch (BinaryFactory.getOpcodeForCategoryTwo(binary)) {
			case 0:
				result = new ADD(binary, currentLine);
				break;
			case 1:
				result = new SUB(binary, currentLine);
				break;
			case 2:
				result = new MUL(binary, currentLine);
				break;
			case 3:
				result = new AND(binary, currentLine);
				break;
			case 4:
				result = new OR(binary, currentLine);
				break;
			case 5:
				result = new XOR(binary, currentLine);
				break;
			case 6:
				result = new NOR(binary, currentLine);
				break;
			default:
				System.out.println("default");
				break;
			}
			break;
		case 7:
			// Category Three Instruction.
			switch (BinaryFactory.getOpcodeForCategoryThree(binary)) {
			case 0:
				result = new ADDI(binary, currentLine);
				break;
			case 1:
				result = new ANDI(binary, currentLine);
				break;
			case 2:
				result = new ORI(binary, currentLine);
				break;
			case 3:
				result = new XORI(binary, currentLine);
				break;
			default:
				System.out.println("default");
				break;
			}
			break;
		default:
			// TODO Throw UnknownInstruction Exception.
			System.out.println("default");
			break;
		}
		return result;
	}

	/**
	 * @param binary
	 * @return
	 */
	public static AbstractData parseData(String binary, int currentLine) {
		AbstractData result = new SignedInteger(binary, currentLine);

		return result;
	}

	/**
	 * @param string
	 * @return
	 */
	private static int getOpcodeForCategoryThree(String string) {
		return Integer.valueOf(string.substring(13, 16), 2).intValue();
	}

	/**
	 * @param string
	 * @return
	 */
	private static int getOpcodeForCategoryTwo(String string) {
		return Integer.valueOf(string.substring(13, 16), 2).intValue();
	}

	/**
	 * @param string
	 * @return
	 */
	private static int getOpcodeForCategoryOne(String string) {
		return Integer.valueOf(string.substring(3, 6), 2).intValue();

	}

	/**
	 * @param string
	 * @return
	 */
	private static int getLeftMostThree(String string) {
		return Integer.valueOf(string.substring(0, 3), 2).intValue();
	}

}
