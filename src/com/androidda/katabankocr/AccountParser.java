package com.androidda.katabankocr;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class AccountParser {
	
	//public static final int CANT_CHARS = 3; // 3 por linea para hacer un numero
	public static final int LINE_WIDTH = 27; // 27 por linea
	public static final int CANT_LINES = 3;// 3 lineas
	public static final int ACCOUNTNUMBER_LENGTH = 9;// 3 numeros valid accounts
	
	private static String[] numeros = new String[ACCOUNTNUMBER_LENGTH];
	
	private String[][][] lines;
	
	public Account account;
	
	private AccountValidator validador = new AccountValidator();
	
	public AccountParser( List<String> lines ) {
		
		float l = lines.size();
		int quantity = (int) Math.ceil(l / 4);
		System.out.println( quantity + " numeros de cuenta");
		
		int num_chars = 3;
		int index = 0;
		for(index=0;index<l;index+=4){
			this.lines = new String[CANT_LINES][ACCOUNTNUMBER_LENGTH][num_chars];
			int c = 0;
			for(int n = index; n<index+CANT_LINES; n++){
				parseLine(new StringBuilder(lines.get(n)), c);
				c++;
			}
			/*
			 * AMD
			 * 9 could be 8
			 * 0 could be 8
			 * 1 could be 7
			 * 5 could be 9 or 6 
			 */
			
			for(int x=0; x<ACCOUNTNUMBER_LENGTH; ++x) {
					numeros[x] =  (validador.isValidNumber(getNumberSequence(x))) ? 
								Integer.toString( validador.getIndentifiedNumber() )
								: 
								"?";				
				
				
				
			}
			boolean amd_flag;
			// detect numero patterns
			if(StringUtils.join(numeros).contains("9") ||
					StringUtils.join(numeros).contains("0") ||
					StringUtils.join(numeros).contains("1") ||
					StringUtils.join(numeros).contains("5")){
				amd_flag = true;
				System.out.println("Scanner problem: options amd activated");
				// Buscar las optiones 
				String s = StringUtils.join(numeros);
				AccountStringOptions options_amd = new AccountStringOptions(s);
				System.out.println(s);
				
				
				
			}

			
			
			account = new Account(numeros);
			
			if(account.isValidAccount()) {
				if(checksum(account.getAccountNumber())) {
					System.out.println("CheckSum valid");
					
				}else{
					account.add(Account.ERR_ERR);
				}
			}else{
				account.add(Account.ERR_ILL);
			}
			
			output(account.getAccountNumber());

		}
		
	}

	
	public void printArraySequence (){
		System.out.println(Arrays.toString(numeros));
	}
	
	
	public String getNumberSequence (int n){
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
		for(int j=0; j<LINE_WIDTH;j++){
			this.lines[n][x][j%3] = el.substring(j,j+1);
			if(j%3 == 2){
				x++;
			}
		}
	} 
	
	public static  boolean checksum (String accountNumber){
		int sum = 0;
		int k = 2;
		for (int i = 0; i < AccountParser.ACCOUNTNUMBER_LENGTH; i++) {
			String character = StringUtils.substring(accountNumber,i,i+1);
			Integer num = Integer.parseInt(character);
			sum = sum + ((AccountParser.ACCOUNTNUMBER_LENGTH - i)* num);
			k++;
		}
		return ((sum % 11) == 0);
	}
	
	private void output(String out) {
		
		
		System.out.println(out);
		
		
		
	}
}