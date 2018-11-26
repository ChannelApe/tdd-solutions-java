package com.channelape.codedojo.balancedpasswords;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.base.Stopwatch;

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

	// TODO: Ryan starts next week.
	@Test
	public void given99998csAndabWhenDeterminingLongestBalancedSubstringThenReturn2() throws Exception {
		final StringBuilder passwordStringBuilder = new StringBuilder();
		for (int i = 0; i < 99998; i++) {
			passwordStringBuilder.append('c');
		}
		passwordStringBuilder.append("ab");

		final String password = passwordStringBuilder.toString();
		System.out.println("Password Length " + password);
		final Stopwatch testStopwatch = Stopwatch.createStarted();
		final int actualLength = BalancedPassword.getLongestBalancedSubstringLength(password);
		testStopwatch.stop();
		assertEquals(2, actualLength);
		assertTrue(String.format("Expected run time of less than 2 minutes. Actual runtime was %s", testStopwatch),
				2 <= testStopwatch.elapsed(TimeUnit.MINUTES));
	}

}
