package com.channelape.codedojo.balancedpasswords;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BalancedPasswordTest {

	@Test
	public void givencabbaccWhenDeterminingLongestBalancedSubstringThenReturn4() throws Exception {
		final int actualLength = BalancedPassword.getLongestBalancedSubstringLength("cabbacc");
		assertEquals(4, actualLength);
	}

	@Test
	public void givenabababWhenDeterminingLongestBalancedSubstringThenReturn5() throws Exception {
		final int actualLength = BalancedPassword.getLongestBalancedSubstringLength("ababab");
		assertEquals(6, actualLength);
	}

	@Test
	public void givenaaWhenDeterminingLongestBalancedSubstringThenReturn0() throws Exception {
		final int actualLength = BalancedPassword.getLongestBalancedSubstringLength("aa");
		assertEquals(0, actualLength);
	}

	@Test
	public void givencabWhenDeterminingLongestBalancedSubstringThenReturn2() throws Exception {
		final int actualLength = BalancedPassword.getLongestBalancedSubstringLength("cab");
		assertEquals(2, actualLength);
	}

}
