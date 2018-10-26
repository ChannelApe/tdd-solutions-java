package com.channelape.codedojo.summationcaryovers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SummationCarryOversTest {

	@Test
	public void given4And5WhenCalculatingCarryOversThenReturn0() throws Exception {
		final int actualCarryOvers = SummationCarryOvers.calculate(4, 5);
		assertEquals(0, actualCarryOvers);
	}

	@Test
	public void given5And5WhenCalculatingCarryOversThenReturn1() throws Exception {
		final int actualCarryOvers = SummationCarryOvers.calculate(5, 5);
		assertEquals(1, actualCarryOvers);
	}

	@Test
	public void given55And55WhenCalculatingCarryOversThenReturn2() throws Exception {
		final int actualCarryOvers = SummationCarryOvers.calculate(55, 55);
		assertEquals(2, actualCarryOvers);
	}

	@Test
	public void given99999And99999WhenCalculatingCarryOversThenReturn5() throws Exception {
		final int actualCarryOvers = SummationCarryOvers.calculate(99999, 99999);
		assertEquals(5, actualCarryOvers);
	}

}
