/**
 * 
 */
package ca.mipssim.model.instruction.categorythree;

/**
 * ADDI(Add Immediate Word) Description : rt <- rs + immediate. (Page 36)
 * 
 * @author ChouSkim
 * 
 */
public class ADDI extends CategoryThree {

	/**
	 * @param binary
	 * @param currentLine
	 */
	public ADDI(String binary, int currentLine) {
		super(binary, currentLine);
		this.instName = "ADDI";
	}

}
