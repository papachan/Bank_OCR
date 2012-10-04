package com.androidda.katabankocr;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class AccountReader {
	
//	public int quantity = 0;
//	private BufferedReader reader;
	private LineNumberReader linecounter;
//	private FileInputStream stream;
//	private DataInputStream input;

	public AccountReader(String string) {
//		reader = new BufferedReader(new StringReader(string));
		linecounter = new LineNumberReader(new StringReader(string));
	}
	public AccountReader(File file) throws FileNotFoundException {
//		reader = new BufferedReader(new FileReader(file));
		linecounter = new LineNumberReader(new FileReader(file));
	}
	public List<String> parseFile() throws Exception {
		List<String> lines = new ArrayList<String>();
		String strline;
		while ((strline = linecounter.readLine()) != null) {
//			Scanner scan = new Scanner(strline);
//			while(scan.hasNext()) {
//				quantity = linecounter.getLineNumber();
//				scan.next();
//			}
//			System.out.println (strline);
//			if(!strline.isEmpty()) {
			lines.add(strline);	
//			}
			
		}
//		System.out.println(quantity);
		return lines;
		
	}
	

}
