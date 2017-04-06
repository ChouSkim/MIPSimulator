/**
 * 
 */
package ca.mipssim.model.instruction.categoryone;

/**
 * BREAK(Breakpoint) Description: A breakpoint exception occurs, immediately and
 * unconditionally transferring control to the exception handler. The code field
 * is available for use as software parameters, but is retrieved by the
 * exception handler only by loading the contents of the memory word containing
 * the instruction. (Page 84)
 * 
 * @author ChouSkim
 * 
 */
public class BREAK extends CategoryOne {

	/**
	 * @param binary
	 * @param currentLine
	 */
	public BREAK(String binary, int currentLine) {
		super(binary, currentLine);

		this.instName = "BREAK";
	}

	/**
	 * Format : BREAK
	 */
	public String parse() {
		return this.instName;

	}

}
