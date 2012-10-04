package com.androidda.katabankocr;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class AccountParser {
	
	public static final int CANT_CHARS = 3; // 3 por linea para hacer un numero
	public static final int LINE_WIDTH = 27; // 27 por linea
	public static final int CANT_LINES = 3;// 3 lineas
	public static final int ACCOUNTNUMBER_LENGTH = 9;// 3 numeros valid accounts
	
	private static int num = 0;
	private static String[] numeros = new String[ACCOUNTNUMBER_LENGTH];
	
	private String[][][] lines;
	
	public Account account;
	
	private AccountValidator validador = new AccountValidator();
	
	public AccountParser( List<String> lines ) {
		
		float l = lines.size();
		int quantity = (int) Math.ceil(l / 4);
		System.out.println( quantity + " numeros de cuenta");
		
		
		String myaccount;
		int index = 0;
		for(index=0;index<l;index+=4){
			this.lines = new String[CANT_LINES][ACCOUNTNUMBER_LENGTH][CANT_CHARS];
			int c = 0;
			for(int n = index; n<index+CANT_LINES; n++){
				parseLine(new StringBuilder(lines.get(n)), c);
				c++;
			}
			for(int x=0; x<ACCOUNTNUMBER_LENGTH; ++x) {
				numeros[x] =  (validador.isValidNumber(this.getNumberSequence(x))) ? 
					Integer.toString( validador.getIndentified_number() )
					: 
					"?";
			}
			myaccount = StringUtils.join(numeros, "");
			account = new Account(myaccount);
			getArraySequence();

		}
		
	}
	
	public void getArraySequence (){
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
//	private void parseLine( StringBuilder el) {
//		int x = 0;
//		for(int j=0; j<LINE_WIDTH;j++){
//			this.lines[this.num][x][j%3] = el.substring(j,j+1);
//			if(j%3 == 2){
//				x++;
//			}
//		}
//		this.num++;
//		
//	}
	

}
