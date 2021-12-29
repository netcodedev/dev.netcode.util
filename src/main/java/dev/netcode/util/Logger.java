package dev.netcode.util;

/**
 * An abstract Class to generalize Logging
 *
 */
public abstract class Logger {

	/**
	 * Creates Logger object
	 */
	public Logger() {}
	
	/**
	 * Logs a message with the specified loglevel to the desired location
	 * @param loglevel of the message
	 * @param message as String
	 * @return the logged message
	 */
	public abstract String log(LogLevel loglevel, String message);
	
	/**
	 * Logs a message from LogMessage object to the desired location
	 * @param message which should be logged
	 * @return the logged message
	 */
	public abstract String log(LogMessage message);
	
}