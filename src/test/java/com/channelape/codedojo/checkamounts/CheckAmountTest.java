package com.channelape.codedojo.checkamounts;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CheckAmountTest {

	@Test
	public void given1WhenSpellingOutCheckAmountThenExpectOneAnd00Over100Dollars() {
		final CheckAmount checkAmount = new CheckAmount("1");
		final String actualSpelledOutCheckAmount = checkAmount.getSpelledOutCheckAmount();
		assertEquals("One and 00/100 dollars", actualSpelledOutCheckAmount);
	}

	@Test
	public void given20WhenSpellingOutCheckAmountThenExpectTwentyAnd00Over100Dollars() {
		final CheckAmount checkAmount = new CheckAmount("20");
		final String actualSpelledOutCheckAmount = checkAmount.getSpelledOutCheckAmount();
		assertEquals("Twenty and 00/100 dollars", actualSpelledOutCheckAmount);
	}

	@Test
	public void given30WhenSpellingOutCheckAmountThenExpectThirtyAnd00Over100Dollars() {
		final CheckAmount checkAmount = new CheckAmount("30");
		final String actualSpelledOutCheckAmount = checkAmount.getSpelledOutCheckAmount();
		assertEquals("Thirty and 00/100 dollars", actualSpelledOutCheckAmount);
	}

	@Test
	public void given40WhenSpellingOutCheckAmountThenExpectFourtyAnd00Over100Dollars() {
		final CheckAmount checkAmount = new CheckAmount("40");
		final String actualSpelledOutCheckAmount = checkAmount.getSpelledOutCheckAmount();
		assertEquals("Forty and 00/100 dollars", actualSpelledOutCheckAmount);
	}

	@Test
	public void given40Dollars10CentsWhenSpellingOutCheckAmountThenExpectFourtyAnd10Over100Dollars() {
		final CheckAmount checkAmount = new CheckAmount("40.10");
		final String actualSpelledOutCheckAmount = checkAmount.getSpelledOutCheckAmount();
		assertEquals("Forty and 10/100 dollars", actualSpelledOutCheckAmount);
	}

	@Test
	public void given55Dollars10CentsWhenSpellingOutCheckAmountThenExpectFiftyFiveAnd10Over100Dollars() {
		final CheckAmount checkAmount = new CheckAmount("55.10");
		final String actualSpelledOutCheckAmount = checkAmount.getSpelledOutCheckAmount();
		assertEquals("Fifty-five and 10/100 dollars", actualSpelledOutCheckAmount);
	}

	@Test
	public void given54Dollars70CentsWhenSpellingOutCheckAmountThenExpectFiftyFourAnd70Over100Dollars() {
		final CheckAmount checkAmount = new CheckAmount("54.70");
		final String actualSpelledOutCheckAmount = checkAmount.getSpelledOutCheckAmount();
		assertEquals("Fifty-four and 70/100 dollars", actualSpelledOutCheckAmount);
	}

	@Test
	public void given10WhenSpellingOutCheckAmountThenExpectTenAnd00Over100Dollars() {
		final CheckAmount checkAmount = new CheckAmount("10");
		final String actualSpelledOutCheckAmount = checkAmount.getSpelledOutCheckAmount();
		assertEquals("Ten and 00/100 dollars", actualSpelledOutCheckAmount);
	}

	@Test
	public void given13WhenSpellingOutCheckAmountThenExpectThirteenAnd00Over100Dollars() {
		final CheckAmount checkAmount = new CheckAmount("13");
		final String actualSpelledOutCheckAmount = checkAmount.getSpelledOutCheckAmount();
		assertEquals("Thirteen and 00/100 dollars", actualSpelledOutCheckAmount);
	}

	@Test
	public void given47DollarsAnd87CentsWhenSpellingOutCheckAmountThenExpectFortySevenAnd87Over100Dollars() {
		final CheckAmount checkAmount = new CheckAmount("47.87");
		final String actualSpelledOutCheckAmount = checkAmount.getSpelledOutCheckAmount();
		assertEquals("Forty-seven and 87/100 dollars", actualSpelledOutCheckAmount);
	}

	@Test
	public void given57DollarsAnd87CentsWhenSpellingOutCheckAmountThenExpectFiftySevenAnd87Over100Dollars() {
		final CheckAmount checkAmount = new CheckAmount("57.87");
		final String actualSpelledOutCheckAmount = checkAmount.getSpelledOutCheckAmount();
		assertEquals("Fifty-seven and 87/100 dollars", actualSpelledOutCheckAmount);
	}

	@Test
	public void given357DollarsAnd87CentsWhenSpellingOutCheckAmountThenExpectThreeHundredFiftySevenAnd87Over100Dollars() {
		final CheckAmount checkAmount = new CheckAmount("357.87");
		final String actualSpelledOutCheckAmount = checkAmount.getSpelledOutCheckAmount();
		assertEquals("Three hundred fifty-seven and 87/100 dollars", actualSpelledOutCheckAmount);
	}

	@Test
	public void given4357DollarsAnd59CentsWhenSpellingOutCheckAmountThenExpectFourThousandThreeHundredFiftySevenAnd59Over100Dollars() {
		final CheckAmount checkAmount = new CheckAmount("4357.59");
		final String actualSpelledOutCheckAmount = checkAmount.getSpelledOutCheckAmount();
		assertEquals("Four thousand three hundred fifty-seven and 59/100 dollars", actualSpelledOutCheckAmount);
	}

	@Test
	public void given673357DollarsAnd59CentsWhenSpellingOutCheckAmountThenExpectSixHundSeventyThreeThousandThreeHundredFiftySevenAnd59Over100Dollars() {
		final CheckAmount checkAmount = new CheckAmount("673357.59");
		final String actualSpelledOutCheckAmount = checkAmount.getSpelledOutCheckAmount();
		assertEquals("Six hundred seventy-three thousand three hundred fifty-seven and 59/100 dollars",
				actualSpelledOutCheckAmount);
	}

	@Test
	public void given200673357DollarsAnd59CentsWhenSpellingOutCheckAmountThenExpectTwoHundredMillionSixHundSeventyThreeThousandThreeHundredFiftySevenAnd59Over100Dollars() {
		final CheckAmount checkAmount = new CheckAmount("200673357.59");
		final String actualSpelledOutCheckAmount = checkAmount.getSpelledOutCheckAmount();
		assertEquals(
				"Two hundred million six hundred seventy-three thousand three hundred fifty-seven and 59/100 dollars",
				actualSpelledOutCheckAmount);
	}

	@Test
	public void given40200673357DollarsAnd00CentsWhenSpellingOutCheckAmountThenExpectFortyBillionTwoHundredMillionSixHundSeventyThreeThousandThreeHundredFiftySevenAnd00Over100Dollars() {
		final CheckAmount checkAmount = new CheckAmount("40200673357.00");
		final String actualSpelledOutCheckAmount = checkAmount.getSpelledOutCheckAmount();
		assertEquals(
				"Forty billion two hundred million six hundred seventy-three thousand three hundred fifty-seven and 00/100 dollars",
				actualSpelledOutCheckAmount);
	}

}
