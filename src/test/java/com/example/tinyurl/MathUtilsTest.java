package com.example.tinyurl;

import com.example.tinyurl.utils.MathUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

	@Test
	public void baseConversionTest() {
		assertEquals("1", MathUtils.base10ToBase62(1L));
		assertEquals("a", MathUtils.base10ToBase62(10L));
		assertEquals("g7", MathUtils.base10ToBase62(999L));
		assertEquals("1ly7vk", MathUtils.base10ToBase62(1234567890L));
		assertEquals("ZZZZZZZ", MathUtils.base10ToBase62(3_521_614_606_207L));
	}

}
