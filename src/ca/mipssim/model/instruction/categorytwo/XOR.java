/**
 * 
 */
package ca.mipssim.model.instruction.categorytwo;

/**
 * XOR(Exclusive OR) Description : rd <- rs XOR rt. (Page 313)
 * 
 * @author ChouSkim
 * 
 */
public class XOR extends CategoryTwo {

	/**
	 * @param binary
	 * @param currentLine
	 */
	public XOR(String binary, int currentLine) {
		super(binary, currentLine);
		this.instName = "XOR";
	}

}
