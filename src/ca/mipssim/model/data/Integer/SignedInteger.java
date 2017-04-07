/**
 * 
 */
package ca.mipssim.model.data.Integer;

import ca.mipssim.model.data.AbstractData;

/**
 * @author ChouSkim
 * 
 */
public class SignedInteger extends AbstractData {

	protected int data;

	/**
	 * @param machineCode
	 * @param currentLine
	 */
	public SignedInteger(String machineCode, int currentLine) {
		super(machineCode, currentLine);
		// TODO Auto-generated constructor stub
	}

	/*
	 * Calculate the signed integer value of a given 32-bit binary code.
	 * 
	 * @see ca.mipssim.model.data.AbstractData#calculate()
	 */
	public String calculate() {
		byte[] bytes = this.machineCode.getBytes();
		int i;

		// minus '0' for calculation
		for (i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) (bytes[i] - '0');
		}

		if (bytes[0] == 1) {
			// For negative immediate, reverse and plus one.
			for (i = 1; i < bytes.length; i++) {
				// reverse.
				bytes[i] = (byte) ((byte) 1 - bytes[i]);
			}

			// plus one.
			for (i = bytes.length - 1; i >= 1 && bytes[i] == 1; i--) {
				bytes[i] = (byte) (bytes[i] - 1);
			}
			bytes[i] = 1;
		} else {
			// For positive immediate, do nothing.
		}

		// plus '0' for transformation to String.
		for (i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) (bytes[i] + '0');
		}

		// Value
		this.data = Integer.valueOf(new String(bytes).substring(1, 32), 2)
				.intValue();
		// Sign
		this.data = (bytes[0] == '1' ? -this.data : this.data);
		return String.valueOf(this.data);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.mipssim.model.data.AbstractData#getData()
	 */
	public int getData() {
		// TODO Auto-generated method stub
		return this.data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.mipssim.model.data.AbstractData#setData()
	 */
	public void setData(int value) {
		// TODO Auto-generated method stub
		this.data = value;
	}
}
