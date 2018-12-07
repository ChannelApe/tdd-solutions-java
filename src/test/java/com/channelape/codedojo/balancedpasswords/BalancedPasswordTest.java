package com.channelape.codedojo.balancedpasswords;

import static org.junit.Assert.assertEquals;

import java.nio.file.Files;
import java.nio.file.Paths;

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
	@Test(timeout = 120000)
	public void given99998csAndabWhenDeterminingLongestBalancedSubstringThenReturn2() throws Exception {
		final String password = new String(
				Files.readAllBytes(Paths.get("src/test/resources/performance_tests/99998csFollowedByab.txt")));
		System.out.println("Password Length " + password.length());
		final Stopwatch testStopwatch = Stopwatch.createStarted();
		final int actualLength = BalancedPassword.getLongestBalancedSubstringLength(password);
		testStopwatch.stop();
		assertEquals(2, actualLength);
		System.out.println(String.format("Elapsed runtime was %s", testStopwatch));
	}

}
