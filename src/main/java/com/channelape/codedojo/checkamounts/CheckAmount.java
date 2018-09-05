package com.channelape.codedojo.checkamounts;

import java.util.HashMap;
import java.util.Map;

public class CheckAmount {

	private final String value;
	private static final Map<Integer, String> digitsToWords;
	static {
		digitsToWords = new HashMap<>();
		digitsToWords.put(1, "one");
		digitsToWords.put(2, "two");
		digitsToWords.put(3, "three");
		digitsToWords.put(4, "four");
		digitsToWords.put(5, "five");
		digitsToWords.put(6, "six");
		digitsToWords.put(7, "seven");
		digitsToWords.put(8, "eight");
		digitsToWords.put(9, "nine");
		digitsToWords.put(10, "ten");
		digitsToWords.put(11, "eleven");
		digitsToWords.put(12, "twelve");
		digitsToWords.put(13, "thirteen");
		digitsToWords.put(14, "fourteen");
		digitsToWords.put(15, "fifteen");
		digitsToWords.put(16, "sixteen");
		digitsToWords.put(17, "seventeen");
		digitsToWords.put(18, "eighteen");
		digitsToWords.put(19, "nineteen");
		digitsToWords.put(20, "twenty");
		digitsToWords.put(30, "thirty");
		digitsToWords.put(40, "forty");
		digitsToWords.put(50, "fifty");
		digitsToWords.put(60, "sixty");
		digitsToWords.put(70, "seventy");
		digitsToWords.put(80, "eighty");
		digitsToWords.put(90, "ninety");
	}

	public CheckAmount(final String value) {
		this.value = value;
	}

	public String getSpelledOutCheckAmount() {
		final String[] dollarsAndCents = this.value.split("\\.");
		final String spelledOutDollarAmount = determineSpelledOutDollarAmount(dollarsAndCents[0]);
		final String finalString = new StringBuilder().append(spelledOutDollarAmount).append(" and ")
				.append(determineCentAmount(dollarsAndCents)).append("/100 dollars").toString();
		return capitalizeFirstLetter(finalString);
	}

	private String determineSpelledOutDollarAmount(final String amount) {
		final int integerAmount = Integer.parseInt(amount);
		if (integerAmount < 1000) {
			return determineHundredsGroup(amount);
		}
		if (integerAmount < 1000000) {
			final int thousandsAmount = integerAmount / 1000;
			final String hundredsAmountString = determineHundredsGroup(
					String.valueOf(integerAmount - (thousandsAmount * 1000)));
			final String thousandsAmountString = determineHundredsGroup(String.valueOf(thousandsAmount));
			return new StringBuilder().append(thousandsAmountString).append(" thousand ").append(hundredsAmountString)
					.toString();
		}
		final int millionsAmount = integerAmount / 1000000;
		final int thousandsAmount = (integerAmount - (millionsAmount * 1000000)) / 1000;
		final int hundredsAmount = (integerAmount - (millionsAmount * 1000000) - (thousandsAmount * 1000));
		final String hundredsAmountString = determineHundredsGroup(String.valueOf(hundredsAmount));
		final String thousandsAmountString = determineHundredsGroup(String.valueOf(thousandsAmount));
		final String millionsAmountString = determineHundredsGroup(String.valueOf(millionsAmount));
		return new StringBuilder().append(millionsAmountString).append("million ").append(thousandsAmountString)
				.append(" thousand ").append(hundredsAmountString).toString();
	}

	private String determineHundredsGroup(final String amount) {
		final String spelledOutDollarAmount;
		int integerAmount = Integer.parseInt(amount);
		if (digitsToWords.containsKey(integerAmount)) {
			spelledOutDollarAmount = digitsToWords.get(integerAmount);
		} else {
			final StringBuilder spelledOutDollarAmountStringBuilder = new StringBuilder();

			final int hundreds = integerAmount / 100;
			if (hundreds > 0) {
				integerAmount -= hundreds * 100;
				spelledOutDollarAmountStringBuilder.append(digitsToWords.get(hundreds)).append(" hundred ");
			}

			final int tens = (integerAmount / 10) * 10;
			if (tens > 0) {
				spelledOutDollarAmountStringBuilder.append(digitsToWords.get(tens)).append('-');
			}

			final int ones = integerAmount % 10;
			if (ones > 0) {
				spelledOutDollarAmountStringBuilder.append(digitsToWords.get(ones));
			}

			spelledOutDollarAmount = spelledOutDollarAmountStringBuilder.toString();
		}
		return spelledOutDollarAmount;
	}

	private String capitalizeFirstLetter(final String spelledOutDollarAmount) {
		final char firstLetterCapitilized = Character.toUpperCase(spelledOutDollarAmount.charAt(0));
		return new StringBuilder().append(firstLetterCapitilized).append(spelledOutDollarAmount.substring(1))
				.toString();
	}

	private String determineCentAmount(final String[] dollarsAndCents) {
		if (dollarsAndCents.length == 1 || dollarsAndCents.length == 0) {
			return "00";
		}
		return dollarsAndCents[1];
	}

}
