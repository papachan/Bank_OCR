package com.androidda.katabankocr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class AccountReader {
	
	private BufferedReader reader;

	public AccountReader(String string) {
		reader = new BufferedReader(new StringReader(string));
	}
	public AccountReader(File file) throws FileNotFoundException {
		reader = new BufferedReader(new FileReader(file));
	}
	public List<String> parseFile() throws Exception {
		List<String> lines = new ArrayList<String>();
		String strline;
		while ((strline = reader.readLine()) != null) {
			lines.add(strline);	
			
		}
		return lines;
		
	}
	

}
