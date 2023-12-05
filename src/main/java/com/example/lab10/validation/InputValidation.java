package com.example.lab10.validation;

/**
 * todo Document type InputValidation
 */
public class InputValidation {
	public static int tryParseInt(String value, int defaultVal) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return defaultVal;
		}
	}
}
