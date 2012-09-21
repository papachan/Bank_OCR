package com.androidda.katabankocr;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class AccountReader {
	
	private BufferedReader reader;
	private FileInputStream fstream;
	private DataInputStream input;

	public AccountReader(String string) {
		this.reader = new BufferedReader(new StringReader(string));
	}
	public AccountReader(File file) throws FileNotFoundException {
		this.reader = new BufferedReader(new FileReader(file));
	}
	public List<String> parseFile() throws Exception {
		String strline;
		List<String> lines = new ArrayList<String>();
		while ((strline = this.reader.readLine()) != null) {
			System.out.println (strline);
			lines.add(strline);
		}
		return lines;
		
	}
	

}
