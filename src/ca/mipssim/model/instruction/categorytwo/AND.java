/**
 * 
 */
package ca.mipssim.model.instruction.categorytwo;

/**
 * AND(And) Description : rd <- rs AND rt (Page 42)
 * 
 * @author ChouSkim
 * 
 */
public class AND extends CategoryTwo {

	/**
	 * @param binary
	 * @param currentLine
	 */
	public AND(String binary, int currentLine) {
		super(binary, currentLine);
		this.instName = "AND";
	}

}
