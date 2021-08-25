package dev.netcode.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

public class TestStringUtils {

	@Test
	void testStringUtils() {
		// padLeft
		assertEquals("-    ",StringUtils.padLeft("-", 5));
		assertEquals("---",StringUtils.padLeft("---", 1));
		assertEquals("null",StringUtils.padLeft(null, 3));
		assertEquals("null ",StringUtils.padLeft(null, 5));
		// padRight
		assertEquals("    -",StringUtils.padRight("-", 5));
		assertEquals("---",StringUtils.padRight("---", 1));
		assertEquals("null",StringUtils.padRight(null, 3));
		assertEquals(" null",StringUtils.padRight(null, 5));
		// applySha526
		assertEquals("8b36dff3778a806688823f1ecf23a5ba4ec4e6d3e59806246f56f3da6586a87b",StringUtils.applySha256("i am gonna be sha256 encoded"));
		assertThrows(IllegalArgumentException.class, ()->StringUtils.applySha256(null));
		// stringToMap
		var inputString = "arg1=val1&arg2=val2";
		var expectedMap = new HashMap<String, String>();
		expectedMap.put("arg1", "val1");
		expectedMap.put("arg2", "val2");
		assertEquals(expectedMap, StringUtils.stringToMap(inputString));
		assertThrows(IllegalArgumentException.class, ()->StringUtils.stringToMap(null));
		// chunkSplit
		inputString = "char should be inserted here: ";
		int length = inputString.length();
		var expected = inputString+"x";
		inputString = inputString.repeat(3);
		expected = expected.repeat(3);
		assertEquals(expected, new String(StringUtils.chunkInsert(inputString, length, 'x')));
		assertThrows(IllegalArgumentException.class, ()->StringUtils.chunkInsert(null, length, 'x'));
		// splitStringEvery
		inputString = "part1part2part3";
		String[] expectedList = {"part1","part2","part3"};
		assertArrayEquals(expectedList, StringUtils.splitStringEvery(inputString, 5));
		assertThrows(IllegalArgumentException.class, ()->StringUtils.splitStringEvery(null, 1));
		assertThrows(IllegalArgumentException.class, ()->StringUtils.splitStringEvery("test", -1));
		// getFileExtension
		assertEquals("file",StringUtils.getFileExtension(new File("C:\\path\\to\\file.file")));
		assertEquals("", StringUtils.getFileExtension(new File("C:\\path\\to\\file")));
	}
	
}
