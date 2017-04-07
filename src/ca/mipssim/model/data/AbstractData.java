/**
 * 
 */
package ca.mipssim.model.data;

import ca.mipssim.model.AbstractBinary;

/**
 * @author ChouSkim
 * 
 */
public abstract class AbstractData extends AbstractBinary {

	/**
	 * @param machineCode
	 * @param currentLine
	 */
	public AbstractData(String machineCode, int currentLine) {
		super(machineCode, currentLine);
		// TODO Auto-generated constructor stub
	}

	public abstract String calculate();

	/**
	 * @return
	 */
	public abstract int getData();

	/**
	 * 
	 * @return
	 */
	public abstract void setData(int value);
}
