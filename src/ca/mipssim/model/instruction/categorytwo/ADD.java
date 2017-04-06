/**
 * 
 */
package ca.mipssim.model.instruction.categorytwo;

/**
 * ADD(Add Word) Description : rd <- rs + rt. (Page 34)
 * 
 * @author ChouSkim
 * 
 */
public class ADD extends CategoryTwo {

	/**
	 * @param binary
	 * @param currentLine
	 */
	public ADD(String binary, int currentLine) {
		super(binary, currentLine);
		this.instName = "ADD";
	}

}
