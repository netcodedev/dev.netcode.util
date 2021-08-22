package dev.netcode.util;

import lombok.Getter;

/**
 * Represents a message which should be logged to an implementation of {@link Logger}.<br>
 * Includes at least the {@link LogLevel} and message. Can additionally include the 
 * stacktrace offset which is a variable that represents the depth of the callstack whenever
 * a message should be logged. It can be used to display the class that called 
 * {@link Logger.log(LogLevel, String)}.<br>
 * It can also include an array of stacktraces which is usually generated whenever an Exception
 * is thrown. This array can be used to customly display the stacktrace.
 */
public class LogMessage {

	@Getter private final LogLevel logLevel;
	@Getter private final String message;
	@Getter private final int stackTraceOffset;
	@Getter private final StackTraceElement[] stacktrace;
	
	/**
	 * Instatiates LogMessage setting stacktrace offset to 0
	 * @param logLevel of the message
	 * @param message to be logged
	 */
	public LogMessage(LogLevel logLevel, String message) {
		this.logLevel = logLevel;
		this.message = message;
		this.stackTraceOffset = 0;
		this.stacktrace = null;
	}
	
	/**
	 * Instatiates LogMessage and sets given stacktrace offset
	 * @param logLevel of the message
	 * @param message to be logged
	 * @param stackTraceOffset of the calling class
	 */
	public LogMessage(LogLevel logLevel, String message, int stackTraceOffset) {
		this.logLevel = logLevel;
		this.message = message;
		this.stackTraceOffset = stackTraceOffset;
		this.stacktrace = null;
	}
	
	/**
	 * Instantiates LogMessage and sets stacktrace offset to 0 
	 * and stacktrace array to given
	 * @param logLevel of the message
	 * @param message to be logged
	 * @param stacktrace of method calls
	 */
	public LogMessage(LogLevel logLevel, String message, StackTraceElement[] stacktrace) {
		this.logLevel = logLevel;
		this.message = message;
		this.stackTraceOffset = 0;
		this.stacktrace = stacktrace;
	}
	
	/**
	 * Instantiates LogMessage and sets stacktrace offset and stacktrace to given variables
	 * @param logLevel of the message
	 * @param message to be logged
	 * @param stackTraceOffset of the calling method
	 * @param stacktrace of method calls
	 */
	public LogMessage(LogLevel logLevel, String message, int stackTraceOffset, StackTraceElement[] stacktrace) {
		this.logLevel = logLevel;
		this.message = message;
		this.stackTraceOffset = 0;
		this.stacktrace = stacktrace;
	}
	
}
