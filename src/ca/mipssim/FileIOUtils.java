/**
 * 
 */
package ca.mipssim;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * @author ChouSkim
 * 
 */
public class FileIOUtils {

	/**
	 * Read a file, and store each line separately in ArrayList.
	 * 
	 * @param fileName
	 *            The name of file.
	 * @return An ArrayList of each line in the file.
	 */
	public static ArrayList inputStringFromFile(String fileName) {
		// TODO Auto-generated method stub
		ArrayList result = new ArrayList();

		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				result.add(tempString);
				System.out.println(tempString);
			}
		} catch (FileNotFoundException e) {
			// FileReader(file)
			e.printStackTrace();
		} catch (IOException e) {
			// reader.readLine()
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Write a String to a given file. If the file exists, cover it.
	 * 
	 * @param string
	 *            The content to be written to file.
	 * @param fileName
	 *            The name of file.
	 */
	public static boolean writeStringToFile(String string, String fileName) {
		try {
			// parameter false means cover the existing content of the file.
			FileOutputStream out = new FileOutputStream(fileName, false);
			out.write(string.getBytes("utf-8"));
			out.close();

			// TODO Remove test code.
			System.out.println(string);
		} catch (FileNotFoundException e) {
			// new FileOutputStream
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// string.getBytes
			e.printStackTrace();
		} catch (IOException e) {
			// out.write & out.close
			e.printStackTrace();
		}

		return true;
	}

}
