package dev.netcode.util;

/**
 * Contains prefixes to change the color of the text inside the console
 */
public enum LogColor {
	/**
	 * Resets the console color to default
	 */
	RESET("\u001b[0m"),
	// 8bit
	/**
	 * Sets text color to black
	 */
	BLACK("\u001b[30m"),
	/**
	 * Sets text color to blue
	 */
	BLUE("\u001b[34m"),
	/**
	 * Sets text color to cyan
	 */
	CYAN("\u001b[36m"),
	/**
	 * Sets text color to green
	 */
	GREEN("\u001b[32m"),
	/**
	 * Sets text color to magenta
	 */
	MAGENTA("\u001b[35m"),
	/**
	 * Sets text color to red
	 */
	RED("\u001b[31m"),
	/**
	 * Sets text color to white
	 */
	WHITE("\u001b[37m"),
	/**
	 * Sets text color to yellow
	 */
	YELLOW("\u001b[33m"),
	//16 bit
	/**
	 * Sets text color to dark gray
	 */
	BRIGHT_BLACK("\u001b[30;1m"),
	/**
	 * Sets text color to brighter blue
	 */
	BRIGHT_BLUE("\u001b[34;1m"),
	/**
	 * Sets text color to brighter cyan
	 */
	BRIGHT_CYAN("\u001b[36;1m"),
	/**
	 * Sets text color to brighter green
	 */
	BRIGHT_GREEN("\u001b[32;1m"),
	/**
	 * Sets text color to brighter magenta
	 */
	BRIGHT_MAGENTA("\u001b[35;1m"),
	/**
	 * Sets text color to brighter red
	 */
	BRIGHT_RED("\u001b[31;1m"),
	/**
	 * Sets text color to brighter white
	 */
	BRIGHT_WHITE("\u001b[37;1m"),
	/**
	 * Sets text color to brighter yellow
	 */
	BRIGHT_YELLOW("\u001b[33;1m"),
	//256 bit
	/**
	 * Sets text color to orange
	 */
	ORANGE("\u001b[38;5;202m"),
	/**
	 * Sets text color to brighter orange
	 */
	BRIGHT_ORANGE("\u001b[38;5;208m"),
	/**
	 * Sets text color to darker orange
	 */
	DARK_ORANGE("\u001b[38;5;166m"),
	/**
	 * Sets text color to purple
	 */
	PURPLE("\u001b[38;5;99m"),
	/**
	 * Sets text color to brighter purple
	 */
	BRIGHT_PURPLE("\u001b[38;5;135m"),
	/**
	 * Sets text color to darker purple
	 */
	DARK_PURPLE("\u001b[38;5;56m"),
	/**
	 * Sets text color to darker blue
	 */
	DARK_BLUE("\u001b[38;5;17m"),
	/**
	 * Sets text color to darker cyan
	 */
	DARK_CYAN("\u001b[38;5;31m"),
	/**
	 * Sets text color to darker green
	 */
	DARK_GREEN("\u001b[38;5;22m"),
	/**
	 * Sets text color to darker magenta
	 */
	DARK_MAGENTA("\u001b[38;5;53m"),
	/**
	 * Sets text color to darker red
	 */
	DARK_RED("\u001b[38;5;52m"),
	/**
	 * Sets text color to light gray
	 */
	DARK_WHITE("\u001b[38;5;244m"),
	/**
	 * Sets text color to darker yellow
	 */
	DARK_YELLOW("\u001b[38;5;136m"),
	/**
	 * Sets background color to black
	 */
	BG_BLACK("\u001b[48;2;0;0;0m");
	
	private String colorcode;
	
	LogColor(String colorcode) {
		this.colorcode = colorcode;
	}
	
	public String toString() {
		return this.colorcode;
	}
}
