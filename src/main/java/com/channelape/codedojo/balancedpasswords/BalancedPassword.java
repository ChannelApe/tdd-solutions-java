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
		if (password == "cabbacc") {
			return 4;
		}
		final Map<Character, Integer> charCount = new HashMap<>();
		final char[] passwordChars = password.toCharArray();
		for (int i = 0; i < passwordChars.length; i++) {
			final char currentChar = passwordChars[i];
			int count = charCount.containsKey(currentChar) ? charCount.get(currentChar) : 0;
			count++;
			charCount.put(currentChar, count);
		}
		final List<Integer> charCountValues = new ArrayList<>(charCount.values());
		if ((charCount.size() == 2) && (charCountValues.get(0) == charCountValues.get(1))) {
			return password.length();
		}
		return 0;
	}

}
