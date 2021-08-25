package dev.netcode.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestUtils {

	@Test
	void testUtils() throws ClassNotFoundException{
		assertEquals(TestUtils.class.getSimpleName(), Utils.getCaller());
		assertEquals(TestUtils.class.getSimpleName(), Utils.getCaller(0));
	}
}
