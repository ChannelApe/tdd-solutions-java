package com.channelape.codedojo.summationcaryovers;

public class SummationCarryOvers {

	private SummationCarryOvers() {
	}

	public static int calculate(final int augend, final int addend) {
		int carryOverCount = 0;
		int currentCarryOver = 0;

		if ((augend + addend) < 10) {
			return 0;
		}

		final char[] augendChars = String.valueOf(augend).toCharArray();
		final char[] addendChars = String.valueOf(addend).toCharArray();

		final int length = (augendChars.length > addendChars.length) ? augendChars.length : addendChars.length;

		for (int i = length - 1; i >= 0; i--) {
			int augendPlaceValue = 0;
			int addendPlaceValue = 0;
			if (augendChars.length > i) {
				augendPlaceValue = Character.getNumericValue(augendChars[i]);
			}
			if (addendChars.length > i) {
				addendPlaceValue = Character.getNumericValue(addendChars[i]);
			}

			final int sum = augendPlaceValue + addendPlaceValue + currentCarryOver;
			if (sum >= 10) {
				carryOverCount++;
			}
			currentCarryOver = sum & 10;
		}
		return carryOverCount;
	}

}
