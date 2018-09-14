package com.channelape.codedojo.checkamounts;

import java.util.HashMap;
import java.util.Map;

public class CheckAmount {

	private final String value;
	private static final Map<Long, String> digitsToWords;
	static {
		digitsToWords = new HashMap<>();
		digitsToWords.put(1L, "one");
		digitsToWords.put(2L, "two");
		digitsToWords.put(3L, "three");
		digitsToWords.put(4L, "four");
		digitsToWords.put(5L, "five");
		digitsToWords.put(6L, "six");
		digitsToWords.put(7L, "seven");
		digitsToWords.put(8L, "eight");
		digitsToWords.put(9L, "nine");
		digitsToWords.put(10L, "ten");
		digitsToWords.put(11L, "eleven");
		digitsToWords.put(12L, "twelve");
		digitsToWords.put(13L, "thirteen");
		digitsToWords.put(14L, "fourteen");
		digitsToWords.put(15L, "fifteen");
		digitsToWords.put(16L, "sixteen");
		digitsToWords.put(17L, "seventeen");
		digitsToWords.put(18L, "eighteen");
		digitsToWords.put(19L, "nineteen");
		digitsToWords.put(20L, "twenty");
		digitsToWords.put(30L, "thirty");
		digitsToWords.put(40L, "forty");
		digitsToWords.put(50L, "fifty");
		digitsToWords.put(60L, "sixty");
		digitsToWords.put(70L, "seventy");
		digitsToWords.put(80L, "eighty");
		digitsToWords.put(90L, "ninety");
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
		final long integerAmount = Long.parseLong(amount);
		if (integerAmount < 1000) {
			return determineHundredsGroup(integerAmount);
		}
		if (integerAmount < 1000000) {
			final long thousandsAmount = integerAmount / 1000L;
			final StringBuilder hundredsAmountString = determineHundredsGroup(integerAmount - (thousandsAmount * 1000));
			final StringBuilder thousandsAmountString = determineHundredsGroup(thousandsAmount);
			return new StringBuilder().append(thousandsAmountString).append(" thousand ").append(hundredsAmountString);
		} else if (integerAmount < 1000000000) {

			final long millionsAmount = integerAmount / 1000000;
			final long thousandsAmount = (integerAmount - (millionsAmount * 1000000)) / 1000;
			final long hundredsAmount = (integerAmount - (millionsAmount * 1000000) - (thousandsAmount * 1000));
			final StringBuilder hundredsAmountString = determineHundredsGroup(hundredsAmount);
			final StringBuilder thousandsAmountString = determineHundredsGroup(thousandsAmount);
			final StringBuilder millionsAmountString = determineHundredsGroup(millionsAmount);
			return new StringBuilder().append(millionsAmountString).append("million ").append(thousandsAmountString)
					.append(" thousand ").append(hundredsAmountString);
		}

		final long billionsAmount = integerAmount / 1000000000;
		final long millionsAmount = (integerAmount - (billionsAmount * 1000000000)) / 1000000;
		final long thousandsAmount = (integerAmount - (billionsAmount * 1000000000) - (millionsAmount * 1000000))
				/ 1000;
		final long hundredsAmount = (integerAmount - (millionsAmount * 1000000) - (billionsAmount * 1000000000)
				- (thousandsAmount * 1000));
		final StringBuilder hundredsAmountString = determineHundredsGroup(hundredsAmount);
		final StringBuilder thousandsAmountString = determineHundredsGroup(thousandsAmount);
		final StringBuilder millionsAmountString = determineHundredsGroup(millionsAmount);
		final StringBuilder billionsAmountString = determineHundredsGroup(billionsAmount);

		return new StringBuilder().append(billionsAmountString).append(" billion ").append(millionsAmountString)
				.append("million ").append(thousandsAmountString).append(" thousand ").append(hundredsAmountString);
	}

	private StringBuilder determineHundredsGroup(long amount) {
		final StringBuilder spelledOutDollarAmountStringBuilder = new StringBuilder();
		if (digitsToWords.containsKey(amount)) {
			spelledOutDollarAmountStringBuilder.append(digitsToWords.get(amount));
		} else {
			final long hundreds = amount / 100;
			if (hundreds > 0) {
				amount -= hundreds * 100;
				spelledOutDollarAmountStringBuilder.append(digitsToWords.get(hundreds)).append(" hundred ");
			}

			final long tens = (amount / 10) * 10;
			if (tens > 0) {
				spelledOutDollarAmountStringBuilder.append(digitsToWords.get(tens)).append('-');
			}

			final long ones = amount % 10;
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
