/**
 * 
 */
package ca.mipssim.model;

/**
 * @author ChouSkim
 * 
 */
public abstract class AbstractBinary {

	protected String machineCode;
	protected int currentLine;

	/**
	 * 
	 */
	public AbstractBinary(String machineCode, int currentLine) {
		this.machineCode = machineCode;
		this.currentLine = currentLine;
	}

	public int getLineNumber() {
		return this.currentLine;
	}

	public String getMachineCode() {
		return this.machineCode;
	}
}
