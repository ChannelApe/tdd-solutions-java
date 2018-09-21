package com.channelape.codedojo.checkamounts;

import java.util.HashMap;
import java.util.Map;

public class CheckAmount {

	private static final char SPACE = ' ';
	private static final String DOLLAR_AND_CENTS_SEPERATOR = "\\.";
	private static final String ZERO_CENTS = "00";
	private static final String OVER_ONE_HUNDRED = "/100 dollars";
	private static final String AND = "and ";
	private static final String HUNDRED_STRING = "hundred";
	private static final String THOUSAND_STRING = "thousand";
	private static final String MILLION_STRING = "million";
	private static final String BILLION_STRING = "billion";
	private static final char DASH = '-';
	private static final int ONE_THOUSAND = 1000;
	private static final int ONE_BILLION = 1000000000;
	private static final int ONE_MILLION = 1000000;
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
		final String[] dollarsAndCents = this.value.split(DOLLAR_AND_CENTS_SEPERATOR);
		final StringBuilder spelledOutDollarAmount = determineSpelledOutDollarAmount(dollarsAndCents[0]);
		final String finalString = new StringBuilder().append(spelledOutDollarAmount).append(AND)
				.append(determineCentAmount(dollarsAndCents)).append(OVER_ONE_HUNDRED).toString();
		return capitalizeFirstLetter(finalString);
	}

	private StringBuilder determineSpelledOutDollarAmount(final String amount) {
		final StringBuilder ret = new StringBuilder();

		final long integerAmount = Long.parseLong(amount);
		if (integerAmount < ONE_THOUSAND) {
			return determineHundredsGroup(integerAmount, ret, "");
		}
		final long billionsAmount = integerAmount / ONE_BILLION;
		final long millionsAmount = (integerAmount - (billionsAmount * ONE_BILLION)) / ONE_MILLION;
		final long thousandsAmount = (integerAmount - (billionsAmount * ONE_BILLION) - (millionsAmount * ONE_MILLION))
				/ ONE_THOUSAND;
		final long hundredsAmount = (integerAmount - (millionsAmount * ONE_MILLION) - (billionsAmount * ONE_BILLION)
				- (thousandsAmount * ONE_THOUSAND));

		determineHundredsGroup(billionsAmount, ret, BILLION_STRING);
		determineHundredsGroup(millionsAmount, ret, MILLION_STRING);
		determineHundredsGroup(thousandsAmount, ret, THOUSAND_STRING);
		determineHundredsGroup(hundredsAmount, ret, HUNDRED_STRING);

		return ret;
	}

	private StringBuilder determineHundredsGroup(long amount, final StringBuilder spelledOutDollarAmountStringBuilder,
			final String placeValueGroup) {
		if (amount == 0) {
			return spelledOutDollarAmountStringBuilder;
		}
		if (digitsToWords.containsKey(amount)) {
			spelledOutDollarAmountStringBuilder.append(digitsToWords.get(amount)).append(SPACE).append(placeValueGroup)
					.append(SPACE);
			return spelledOutDollarAmountStringBuilder;
		} else {

			final long hundreds = amount / 100;
			if (hundreds > 0) {
				amount -= hundreds * 100;
				spelledOutDollarAmountStringBuilder.append(digitsToWords.get(hundreds)).append(SPACE)
						.append(HUNDRED_STRING);
			}

			final long tens = (amount / 10) * 10;
			if (tens > 0) {
				if (hundreds > 0) {
					spelledOutDollarAmountStringBuilder.append(SPACE);
				}
				spelledOutDollarAmountStringBuilder.append(digitsToWords.get(tens)).append(DASH);
			}

			final long ones = amount % 10;
			if (ones > 0) {
				spelledOutDollarAmountStringBuilder.append(digitsToWords.get(ones));
			}
		}
		spelledOutDollarAmountStringBuilder.append(SPACE).append(placeValueGroup);
		if (!placeValueGroup.equals("")) {
			spelledOutDollarAmountStringBuilder.append(SPACE);
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
			return ZERO_CENTS;
		}
		return dollarsAndCents[1];
	}

}
