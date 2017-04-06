/**
 * 
 */
package ca.mipssim.model.instruction.categorytwo;

/**
 * NOR(Not Or) Description : rd <- rs NOR rt
 * 
 * @author ChouSkim
 * 
 */
public class NOR extends CategoryTwo {

	/**
	 * @param binary
	 * @param currentLine
	 */
	public NOR(String binary, int currentLine) {
		super(binary, currentLine);
		this.instName = "NOR";
	}

}
