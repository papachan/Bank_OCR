package com.androidda.katabankocr;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class AccountParser {
	
//	public static final int CANT_CHARS = 3; // 3 por linea para hacer un numero
//	public static final int LINE_WIDTH = 27; // 27 por linea
	public static final int CANT_LINES = 3;// 3 lineas
	public static final int ACCOUNTNUMBER_LENGTH = 9;// 3 numeros valid accounts
	
	private String[][][] lines;
	
	public Account account;
	
	public AccountParser( List<String> lines ) {
		
		String[] numeros = new String[ACCOUNTNUMBER_LENGTH];
		float l = lines.size();
		int quantity = (int) Math.ceil(l / 4);
		System.out.println( quantity + " account number");
		
		int num_chars = 3;
		int index = 0;
		for(index=0;index<l;index+=4) {
			int c = 0;
			this.lines = new String[CANT_LINES][ACCOUNTNUMBER_LENGTH][num_chars];
			for(int n = index; n<index+CANT_LINES; n++){
				parseLine(new StringBuilder(lines.get(n)), c);
				c++;
			}
			for(int x=0; x<ACCOUNTNUMBER_LENGTH; ++x) {
				numeros[x] =  AccountValidator.getIndentifiedNumber(getNumberSequence(x));
			}
			
			String cad = StringUtils.join(numeros, "");

			
			// Account finally created
			account = new Account(cad);
			if(account.isValidAccount()) {
				if(checksum(account.getAccountNumber())) {
					System.out.println("CheckSum valid");
					
				} 
				 else {
				 
					getOptionsAMB(account);
//					account.append(Account.ERR_ERR);
					
				}
				
			} else {
				getOptionsAMB(account);
				account.append(Account.ERR_ILL);
				
				
			}
			
			output(account.getAccountNumber());
			

		}
		
	}
	private void getOptionsAMB(Account account) {
		if(AccountStringOptions.repeatedNumbersRegExp( 
				account.getAccountNumber(), 
				AccountStringOptions.pattern ) > 0) {
			AccountStringOptions options_amd = new AccountStringOptions(account.getAccountNumber());
			// get all options into an array and valid checksum
			String str = options_amd.getOptions();
			account.setTransformedNumber(str);
			account.append(Account.OPTIONS_AMB);
			System.out.println("number of finded options:" + options_amd.getCantOptions());
			System.out.println("alternate:" + account.getTransformedNumber());
			// only change a pipe
			// valid it to checksum
			
		}
	}
	
	public String getNumberSequence (int n) {
		String str = new String();
		for(int l=0;l<3;++l){
			for(int i=0;i<3;++i){
				str += new String(this.lines[l][n][i]);
			}
		}
		return str;
	}

	private void parseLine( StringBuilder el, int n) {
		int x = 0;
		int line_width = Math.round(CANT_LINES * ACCOUNTNUMBER_LENGTH);
		for(int j=0; j<line_width;j++){
			this.lines[n][x][j%3] = el.substring(j,j+1);
			if(j%3 == 2){
				x++;
			}
		}
	} 
	
	public static  boolean checksum (String accountNumber){
		int sum = 0;
		for (int i = 0; i < AccountParser.ACCOUNTNUMBER_LENGTH; i++) {
			String character = StringUtils.substring(accountNumber,i,i+1);
			Integer num = Integer.parseInt(character);
			sum = sum + ((AccountParser.ACCOUNTNUMBER_LENGTH - i)* num);
		}
		return ((sum % 11) == 0);
	}
	
	private void output(String out) {
		
		
		System.out.println("output:" + out);
		
		
		
	}
}