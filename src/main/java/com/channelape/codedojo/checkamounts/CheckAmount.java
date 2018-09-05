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
		final StringBuilder spelledOutDollarAmount = determineSpelledOutDollarAmount(dollarsAndCents[0]);
		final String finalString = new StringBuilder().append(spelledOutDollarAmount).append(" and ")
				.append(determineCentAmount(dollarsAndCents)).append("/100 dollars").toString();
		return capitalizeFirstLetter(finalString);
	}

	private StringBuilder determineSpelledOutDollarAmount(final String amount) {
		final int integerAmount = Integer.parseInt(amount);
		if (integerAmount < 1000) {
			return determineHundredsGroup(integerAmount);
		}
		if (integerAmount < 1000000) {
			final int thousandsAmount = integerAmount / 1000;
			final StringBuilder hundredsAmountString = determineHundredsGroup(integerAmount - (thousandsAmount * 1000));
			final StringBuilder thousandsAmountString = determineHundredsGroup(thousandsAmount);
			return new StringBuilder().append(thousandsAmountString).append(" thousand ").append(hundredsAmountString);
		}
		final int millionsAmount = integerAmount / 1000000;
		final int thousandsAmount = (integerAmount - (millionsAmount * 1000000)) / 1000;
		final int hundredsAmount = (integerAmount - (millionsAmount * 1000000) - (thousandsAmount * 1000));
		final StringBuilder hundredsAmountString = determineHundredsGroup(hundredsAmount);
		final StringBuilder thousandsAmountString = determineHundredsGroup(thousandsAmount);
		final StringBuilder millionsAmountString = determineHundredsGroup(millionsAmount);
		return new StringBuilder().append(millionsAmountString).append("million ").append(thousandsAmountString)
				.append(" thousand ").append(hundredsAmountString);
	}

	private StringBuilder determineHundredsGroup(int amount) {
		final StringBuilder spelledOutDollarAmountStringBuilder = new StringBuilder();
		if (digitsToWords.containsKey(amount)) {
			spelledOutDollarAmountStringBuilder.append(digitsToWords.get(amount));
		} else {
			final int hundreds = amount / 100;
			if (hundreds > 0) {
				amount -= hundreds * 100;
				spelledOutDollarAmountStringBuilder.append(digitsToWords.get(hundreds)).append(" hundred ");
			}

			final int tens = (amount / 10) * 10;
			if (tens > 0) {
				spelledOutDollarAmountStringBuilder.append(digitsToWords.get(tens)).append('-');
			}

			final int ones = amount % 10;
			if (ones > 0) {
				spelledOutDollarAmountStringBuilder.append(digitsToWords.get(ones));
			}
		}
		return spelledOutDollarAmountStringBuilder;
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
