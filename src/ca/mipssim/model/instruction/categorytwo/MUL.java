/**
 * 
 */
package ca.mipssim.model.instruction.categorytwo;

/**
 * MUL(Multiply Word to GPR) Description : rd <- rs * rt. (Page 207)
 * 
 * @author ChouSkim
 * 
 */
public class MUL extends CategoryTwo {

	/**
	 * @param binary
	 * @param currentLine
	 */
	public MUL(String binary, int currentLine) {
		super(binary, currentLine);
		this.instName = "MUL";
	}

}
