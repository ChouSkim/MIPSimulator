/**
 * 
 */
package ca.mipssim.model.instruction.categoryone;

import java.util.ArrayList;

import ca.mipssim.model.data.AbstractData;

/**
 * LW(Load Word) Description: rt <- memory[base+offset]. (Page 161)
 * 
 * @author ChouSkim
 * 
 */
public class LW extends CategoryOne {

	int base;
	int rt;
	int offset;

	/**
	 * @param binary
	 * @param currentLine
	 */
	public LW(String binary, int currentLine) {
		super(binary, currentLine);
		this.instName = "LW";

		base = Integer.valueOf(machineCode.substring(6, 11), 2).intValue();
		rt = Integer.valueOf(machineCode.substring(11, 16), 2).intValue();
		// Note: no sign-extend here.
		offset = Integer.valueOf(machineCode.substring(16, 32), 2).intValue();
	}

	/**
	 * Format : LW rt, offset(base)
	 */
	public String parse() {
		this.assemblyCode = this.instName + " R" + this.rt + ", " + this.offset
				+ "(R" + this.base + ")";
		return this.assemblyCode;
	}

	/**
	 * memword <- LoadMemory (CCA, WORD, pAddr, vAddr, DATA)<BR/>
	 * GPR[rt] <- memword<BR/>
	 * 
	 * @see ca.mipssim.model.instruction.AbstractInstruction#execute(java.util.ArrayList
	 *      , java.util.ArrayList, int)
	 */
	public int execute(ArrayList registerList, ArrayList dataList, int PC,
			final int dataStart) {
		// TODO Test.
		System.out.println("LW : " + this.offset + " " + this.base);

		int baseValue = ((Integer) registerList.get(this.base)).intValue();
		int target_offset = (this.offset + baseValue - dataStart) >> 2;

		// Note: registerList stores type Integer rather than AbstractData.
		Integer result = Integer.valueOf(((AbstractData) dataList
				.get(target_offset)).getData());

		registerList.set(this.rt, result);
		return PC;
	}
}
