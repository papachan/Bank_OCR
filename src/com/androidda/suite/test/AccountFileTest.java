package com.androidda.suite.test;

import java.io.FileNotFoundException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.androidda.katabankocr.KataBankOCR;

import junit.framework.TestCase;

public class AccountFileTest extends TestCase {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testThrowFileNotFoundException() {
		thrown.expect(FileNotFoundException.class);
		String[] args = new String[1];
		KataBankOCR.main(args);
		
	}
	

}