package dev.netcode.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * This class contains some different functions so that you dont need to implement them
 */
public class Utils {
	
	/**
	 * @return current time in HH:mm:ss format (e.g. 17:59:38)
	 */
	public static String getTime() {
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(cal.getTime());
	}
	
	/**
	 * @return current date in d.MM.YYYY format (e.g. 21.01.2021)
	 */
	public static String getDate() {
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("d.MM.YYYY");
		return sdf.format(cal.getTime());
	}
	
	/**
	 * This function returns the name of the class that contained the function 
	 * that called this function (think about it. it makes sense). That way you
	 * can find out which class called a specific function.
	 * @return the caller of the function that called this function
	 * @throws ClassNotFoundException shouldn't really be thrown
	 */
	public static String getCaller() {
		return getCaller(1);
	}
	
	/**
	 * This function returns the name of the class that contained the function 
	 * that called this function (think about it. it makes sense). That way you
	 * can find out which class called a specific function.
	 * @param offset to add to the stack trace if it was passed through any other class
	 * @return the name of the calling class
	 * @throws ClassNotFoundException shouldn't really be thrown
	 */
	public static String getCaller(int offset) {
		var elem = Thread.currentThread().getStackTrace()[offset+2];
		String className = null;
		try {
			className = Class.forName(elem.getClassName()).getSimpleName();
		} catch (ClassNotFoundException e) {
			//this should be safe to be ignored
		}
		return className;
	}
	
	
}
