package dev.netcode.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class contains functions to generate, manipulate or use Strings
 */
public class StringUtils {

	/**
	 * This class adds spaces to the end of the given string so that
	 * the total length of the string is equal to totalLength.
	 * If totalLength is less or equal to the strings length no spaces
	 * are added and original input is returned. If input string is null,
	 * the result will be aswell.
	 * @param string to pad
	 * @param totalLength of the result string
	 * @return string that has been filled up with spaces to the length of totalLength
	 */
	public static String padLeft(String string, int totalLength) {
		return String.format("%-"+totalLength+"s", string);
	}

	/**
	 * This class adds spaces to the begin of the given string so that
	 * the total length of the string is equal to totalLength.
	 * If totalLength is less or equal to the strings length no spaces
	 * are added and original input is returned. If input string is null,
	 * the result will be aswell.
	 * @param string to pad
	 * @param totalLength of the result string
	 * @return string that has been filled up with spaces to the length of totalLength
	 */
	public static String padRight(String string, int totalLength) {
		return String.format("%"+totalLength+"s", string);
	}
	
	/**
	 * Decodes escaped special chars from URLs like '%20' to their
	 * UTF-8 counterpart
	 * @param encoded URL
	 * @return decoded URL
	 */
	public static String decodeURL(String encoded) {
        try {
            return URLDecoder.decode(encoded, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }
	
	/**
	 * Applies the SHA-256 algorithm to the given input.
	 * Input gets converted to UTF-8
	 * @param input to apply the SHA-256 algorithm to
	 * @return hexadecimal representation of SHA-256 applied string
	 */
	public static String applySha256(String input){		
		if(input == null) {
			throw new IllegalArgumentException("input is null");
		}
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");	        
			//Applies sha256 to our input, 
			byte[] hash = digest.digest(input.getBytes("UTF-8"));	        
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Reads file into byte array
	 * @param file to be read
	 * @param fileLength of the file
	 * @return byte contents of the file
	 * @throws IOException if something fails
	 */
	public static byte[] readFileData(File file, int fileLength) throws IOException {
		FileInputStream fileIn = null;
		byte[] fileData = new byte[fileLength];
		
		try {
			fileIn = new FileInputStream(file);
			fileIn.read(fileData);
		} finally {
			if (fileIn != null) 
				fileIn.close();
		}
		
		return fileData;
	}
	
	/**
	 * Saves a string to a file
	 * @param file Path of the file to save the data in
	 * @param data to save
	 * @return true if storing the data was successful, false otherwise
	 */
	public static boolean saveToFile(Path file, String data) {
		try {
			FileOutputStream fos = new FileOutputStream(file.toFile().getAbsolutePath());
			fos.write(data.getBytes());
			fos.close();
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	/**
	 * Translates a String in the form of key=value&amp;key2=value2... to a {@link HashMap}.
	 * @param input string
	 * @return {@link HashMap} representing the input string
	 */
	public static HashMap<String, String> stringToMap(String input) { 
		if(input == null) {
			throw new IllegalArgumentException("input is null");
		}
		HashMap<String, String> map = new HashMap<String, String>();
		String[] nameValuePairs = input.split("&");
		for (String nameValuePair : nameValuePairs) {
			String[] nameValue = nameValuePair.split("=");
			try {
				map.put(URLDecoder.decode(nameValue[0], "UTF-8"), nameValue.length > 1 ? URLDecoder.decode(nameValue[1], "UTF-8") : "");
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException("This method requires UTF-8 encoding support", e);
			}
		}
		return map;
	}
	
	/**
	 * Inserts a char into a string after every n chars. 
	 * Can for example be used to add a linebreak every n characters
	 * @param data to insert the chars into
	 * @param n offset between inserts
	 * @param insert char
	 * @return byte array with inserted chars
	 */
	public static byte[] chunkInsert(String data, int n, char insert) {
		if(data == null) {
			throw new IllegalArgumentException("input String is null");
		}
		ArrayList<Byte> byteList = new ArrayList<Byte>();
		
		for(int i = 0; i<data.length(); i++) {
			byteList.add((byte)data.charAt(i));
			if((i+1)%n==0) {
				byteList.add((byte)insert);
			}
		}
		byte[] result = new byte[byteList.size()];
		for(int i = 0; i<byteList.size(); i++) {
			result[i] = byteList.get(i);
		}
		return result;
	}
	
	/**
	 * splits a given string into parts of maximum length of interval
	 * @param s to split
	 * @param interval amount of chars to split the string after
	 * @return array of strings representing splitted input
	 */
	public static String[] splitStringEvery(String s, int interval) {
		if(s == null) {
			throw new IllegalArgumentException("input string is null");
		}
		if(interval < 0) {
			throw new IllegalArgumentException("interval must be greater or equal to 0");
		}
	    int arrayLength = (int) Math.ceil(((s.length() / (double)interval)));
	    String[] result = new String[arrayLength];

	    int j = 0;
	    int lastIndex = result.length - 1;
	    for (int i = 0; i < lastIndex; i++) {
	        result[i] = s.substring(j, j + interval);
	        j += interval;
	    } //Add the last bit
	    result[lastIndex] = s.substring(j);

	    return result;
	}
	
	/**
	 * Returns the file extension of a file.
	 * If file has no extension an empty String is returned
	 * @param file to get the extension of
	 * @return the files extension
	 */
	public static String getFileExtension(File file) {
		String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
        	return fileName.substring(fileName.lastIndexOf(".")+1);
        } else {
        	return "";
        }
    }
	
	/**
	 * Converts a byte array to hexadecimal represented String
	 * @param bytes to transform
	 * @return hexadecimal representation
	 */
	public static String bytesToHex(byte[] bytes) {
		StringBuilder string = new StringBuilder();
		for (byte b : bytes) {
			String hexString = Integer.toHexString(0x00FF & b);
			string.append(hexString.length() == 1 ? "0" + hexString : hexString);
		}
		return string.toString();
	}
	
	/**
	 * Converts a hexadecimal string to byte array
	 * @param string to transform
	 * @return byte representation
	 */
	public static byte[] hexStringToByteArray(String string) {
	    int len = string.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(string.charAt(i), 16) << 4)
	                             + Character.digit(string.charAt(i+1), 16));
	    }
	    return data;
	}
	
	/**
	 * Decodes a hexadecimal string
	 * @param hexStr hexadecimal string to be decoded
	 * @return decoded string
	 */
	public static String hexToString(String hexStr) {
	    StringBuilder output = new StringBuilder("");
	     
	    for (int i = 0; i < hexStr.length(); i += 2) {
	        String str = hexStr.substring(i, i + 2);
	        output.append((char) Integer.parseInt(str, 16));
	    }
	     
	    return output.toString();
	}
	
}
