/**
 * 
 */
package ca.mipssim.model.instruction.categorythree;

/**
 * @author ChouSkim
 * 
 */
public class XORI extends CategoryThree {

	/**
	 * @param binary
	 * @param currentLine
	 */
	public XORI(String binary, int currentLine) {
		super(binary, currentLine);
		this.instName = "XORI";
	}

}
