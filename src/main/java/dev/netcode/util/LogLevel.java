package dev.netcode.util;

/**
 * Represents different log levels to group messages by their importancy
 */
public enum LogLevel {
	/**
	 * Should be used when exceptions occur or
	 * invalid data was used
	 */
	ERROR,
	/**
	 * Should be used to warn the user to pay 
	 * attention
	 */
	WARNING,
	/**
	 * Should be used to inform the user
	 */
	INFO,
	/**
	 * Can be used to indicate the following message
	 * to be sent by a server
	 */
	SERVER,
	/**
	 * Should be used to inform the user 
	 * with higher draw of attention
	 */
	IMPORTANT
}
