/**
 * 
 */
package ca.mipssim.model.instruction.categorytwo;

/**
 * SUB(Substract Word) Description : rd <- rs - rt. (Page 266)
 * 
 * @author ChouSkim
 * 
 */
public class SUB extends CategoryTwo {

	/**
	 * @param binary
	 * @param currentLine
	 */
	public SUB(String binary, int currentLine) {
		super(binary, currentLine);
		this.instName = "SUB";
	}

}
