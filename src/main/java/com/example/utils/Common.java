package com.example.utils;

public class Common {
	
	/**
	 * check the number of halfsize
	 *
	 * @param input string requires processing
	 * @return true if input is number of halfsize else flase
	 */
	public static boolean checkNumber(String input) {
		return replaceData(input).matches("^[0-9]+$");
	}
	
	/**
	 * Processing input string from view
	 *
	 * @param input string requires processing
	 * @return string after processing
	 */
	public static String replaceData(String input) {
		if (input != null) {
			input = input.replace("\\s+", "");
			input = input.replace("-", "");
		}
		return input;
	}
}
