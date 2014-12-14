package org.upasx.lichee.server.util;

/**
 * 
 * @author Andy
 *
 */
public class DataUtil {
	/**
	 * convert a string to short value
	 */
	public static double stringToDouble(String strValue) {
		if (strValue == null) {
			return 0.0;
		}
		
		strValue = strValue.trim();		
		if (strValue.equals("")) {
			return 0.0;
		} else {
			return Double.parseDouble(strValue);
		}
	}
}
