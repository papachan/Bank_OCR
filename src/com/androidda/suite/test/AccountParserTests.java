package com.androidda.suite.test;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;

import com.androidda.katabankocr.AccountParser;

public class AccountParserTests extends TestCase {
	
	@Test
	public void testSumDigits() {
		String digits = "345882865";
		Assert.assertTrue(AccountParser.checksum(digits));
		
	}
	@Test
	public void testSumDigitsError() {
		String digits = "145882865";
		Assert.assertFalse(AccountParser.checksum(digits));
		
	}
	

}
