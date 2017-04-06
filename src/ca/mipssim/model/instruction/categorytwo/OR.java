/**
 * 
 */
package ca.mipssim.model.instruction.categorytwo;

/**
 * OR(Or) Description : rd <- rs or rt (Page 218)
 * 
 * @author ChouSkim
 * 
 */
public class OR extends CategoryTwo {

	/**
	 * @param binary
	 * @param currentLine
	 */
	public OR(String binary, int currentLine) {
		super(binary, currentLine);
		this.instName = "OR";
	}

}
