package dev.netcode.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestResult {

	@Test
	void testResult() {
		var result = new Result<String>("test",null);
		assertTrue(result.wasSuccessful());
		assertEquals("test", result.get());
		assertNull(result.getError());
		result = new Result<String>(null, "error");
		assertFalse(result.wasSuccessful());
		assertEquals("error", result.getError());
		assertNull(result.get());
		result = new Result<String>("test","error");
		assertFalse(result.wasSuccessful());
		assertEquals("error", result.getError());
		assertNull(result.get());
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Result<String>(null,null));
		assertEquals("Result expects exactly one parameter to be not-null", exception.getMessage());
	}
	
}
