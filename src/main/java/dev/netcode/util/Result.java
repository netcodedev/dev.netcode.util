package dev.netcode.util;

/**
 * Instances of this class can be used when a function may encounter an error and
 * wants to display the error message but you want to manually display it.
 * @param <T> type of object the function should have returned
 */
public class Result<T> {
	
	private T value;
	private String error;
	
	/**
	 * Instantiates Result and sets either the value or error
	 * @param value if successful or null
	 * @param error if failed or null
	 */
	public Result(T value, String error){
		this.value = value;
		this.error = error;
	}
	
	/**
	 * @return whether retrieving the result was successful
	 */
	public boolean wasSuccessful() {
		return value!=null;
	}
	
	/**
	 * @return the result
	 */
	public T get() {
		return value;
	}
	
	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}
}
