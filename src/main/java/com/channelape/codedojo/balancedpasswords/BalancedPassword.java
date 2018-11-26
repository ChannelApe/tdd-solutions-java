package com.channelape.codedojo.balancedpasswords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * TDD solution for https://app.codility.com/programmers/task/balanced_password/
 *
 */
public class BalancedPassword {

	private BalancedPassword() {

	}

	public static int getLongestBalancedSubstringLength(final String password) {
		int longestBalancedSubstringLength = 0;
		for (int i = 0; i < password.length(); i++) {
			for (int j = i + 1; j <= password.length(); j++) {
				final String passwordSubstring = password.substring(i, j);
				final int substringLength = getSubstringLength(passwordSubstring);
				if (substringLength > longestBalancedSubstringLength) {
					longestBalancedSubstringLength = substringLength;
				}
			}
		}
		return longestBalancedSubstringLength;
	}

	private static int getSubstringLength(final String passwordSubstring) {
		if ((passwordSubstring.length() % 2) == 0) {
			final Map<Character, Integer> charCount = new HashMap<>();
			final char[] passwordChars = passwordSubstring.toCharArray();
			for (int i = 0; i < passwordChars.length; i++) {
				final char currentChar = passwordChars[i];
				int count = charCount.containsKey(currentChar) ? charCount.get(currentChar) : 0;
				count++;
				charCount.put(currentChar, count);

				if (charCount.size() > 2) {
					return 0;
				}
			}
			final List<Integer> charCountValues = new ArrayList<>(charCount.values());
			if ((charCount.size() == 2) && (charCountValues.get(0) == charCountValues.get(1))) {
				return passwordSubstring.length();
			}
		}
		return 0;
	}

}
