/**
 * 
 */
package ca.mipssim.model.instruction.categorythree;

/**
 * @author ChouSkim
 * 
 */
public class ANDI extends CategoryThree {

	/**
	 * @param binary
	 * @param currentLine
	 */
	public ANDI(String binary, int currentLine) {
		super(binary, currentLine);
		this.instName = "ANDI";
	}

}
