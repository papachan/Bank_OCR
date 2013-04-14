package com.androidda.suite.test;

import junit.framework.TestCase;

import org.junit.Test;

import com.androidda.katabankocr.AccountCheck;

public class AccountParserTests extends TestCase {
	
	@Test
	public void parsingFileTest() {
	}
	
	@Test
	public void testSumDigits() {
		String digits = "345882865";
		this.assertTrue(AccountCheck.checksum(digits));
		
	}
	@Test
	public void testSumDigitsError() {
		String digits = "145882865";
		this.assertFalse(AccountCheck.checksum(digits));
		
	}
	@Test 
	public void testParseError() {
		
	}

}
