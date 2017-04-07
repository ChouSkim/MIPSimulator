/**
 * 
 */
package ca.mipssim.model.instruction.categoryone;

import java.util.ArrayList;

import ca.mipssim.model.data.AbstractData;

/**
 * SW(Store Word) Description: memory[base+offset] <- rt. (Page 270)
 * 
 * @author ChouSkim
 * 
 */
public class SW extends CategoryOne {

	int base;
	int rt;
	int offset;

	/**
	 * @param binary
	 * @param currentLine
	 */
	public SW(String binary, int currentLine) {
		super(binary, currentLine);
		this.instName = "SW";

		base = Integer.valueOf(machineCode.substring(6, 11), 2).intValue();
		rt = Integer.valueOf(machineCode.substring(11, 16), 2).intValue();
		offset = Integer.valueOf(machineCode.substring(16, 32), 2).intValue();
	}

	/**
	 * Format : SW rt, offset(base)
	 */
	public String parse() {
		this.assemblyCode = this.instName + " R" + this.rt + ", " + this.offset
				+ "(R" + this.base + ")";
		return this.assemblyCode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ca.mipssim.model.instruction.AbstractInstruction#execute(java.util.ArrayList
	 * , java.util.ArrayList, int, int)
	 */
	public int execute(ArrayList registerList, ArrayList dataList, int PC,
			int dataStart) {
		// TODO Test.
		int baseValue = ((Integer) registerList.get(this.base)).intValue();
		int target_offset = (this.offset + baseValue - dataStart) >> 2;

		// Note: dataList stores type AbstractData rather than Integer.
		AbstractData result = (AbstractData) dataList.get(target_offset);
		result.setData(((Integer) registerList.get(this.rt)).intValue());

		dataList.set(target_offset, result);

		System.out.println("SW: baseValue " + baseValue + " target_offset "
				+ target_offset);
		return PC;
	}
}
