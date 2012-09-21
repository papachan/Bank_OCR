package com.androidda.junit.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.androidda.katabankocr.KataBankOCR;

public class MyClassTest {

	@Test
	public void testMultiply() {
		KataBankOCR tester = new KataBankOCR();
		assertEquals("Result", 50, tester.multiply(10, 5));
		
		
		
	}

}
