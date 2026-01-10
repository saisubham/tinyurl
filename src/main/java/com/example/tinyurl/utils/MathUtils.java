package com.example.tinyurl.utils;

public class MathUtils {
	private static final String CHARACTERS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static String base10ToBase62(long num) {
		if (num == 0) {
			return "0";
		}

		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			int remainder = (int) (num % 62);
			sb.append(CHARACTERS.charAt(remainder));
			num /= 62;
		}

		// The characters are collected in reverse order during division
		return sb.reverse().toString();
	}
}
