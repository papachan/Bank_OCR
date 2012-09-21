package com.androidda.katabankocr;

import java.io.File;
import java.io.FileNotFoundException;

public class KataBankOCR {
	
	
	public static void main(String[] args) {
		
		try{
			
			File file = new File(args[0]);
			
			AccountReader reader = new AccountReader( file );
			AccountParser parser = new AccountParser(reader.parseFile());

			
		} catch (FileNotFoundException fnfe) {
			System.out.println("error");
			
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			
		}
	}
	// this is just an empty function to be valided with JUNIT
	public int multiply (int x, int y) {
		return x * y;
	}

}