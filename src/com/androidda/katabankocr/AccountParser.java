package com.androidda.katabankocr;

import java.util.Arrays;
import java.util.List;

public class AccountParser {
	
	public static final int CANT_CHARS = 3; // 3 por linea para hacer un numero
	public static final int LINE_WIDTH = 27; // 27 por linea
	public static final int CANT_LINES = 3;// 3 lineas
	public static final int ACCOUNTNUMBER_LENGTH = 9;// 3 numeros valid accounts
	
	private static int num = 0;
	private static int[] numeros = new int[ACCOUNTNUMBER_LENGTH];
	
	private String[][][] lines;
	
	public AccountParser( List<String> lines ) {
		
		AccountValidator validador = new AccountValidator();
		
		// Armar el tablero multidimencional de las 3 lineas leidas en el archivo
		this.lines = new String[CANT_LINES][ACCOUNTNUMBER_LENGTH][CANT_CHARS];
		for(int n = 0; n<CANT_LINES; n++){
			parseLine(new StringBuilder(lines.get(n)));
		}
		for(int x=0; x<ACCOUNTNUMBER_LENGTH; x++) {
			if(validador.isValidNumber(this.getNumberSequence(x))) {
				numeros[x] = validador.getIndentified_number();
			}
		}
		
		System.out.println(Arrays.toString(numeros));
		System.out.println("totaly finish parsing");
		
	}
	public String getNumberSequence (int n){
		String str = new String();
		str = this.lines[0][n][0] + this.lines[0][n][1] + this.lines[0][n][2];
		str += this.lines[1][n][0] + this.lines[1][n][1] + this.lines[1][n][2];
		str += this.lines[2][n][0] + this.lines[2][n][1] + this.lines[2][n][2];
		return str;
	}
	private void parseLine( StringBuilder el) {
		int x = 0;
		for(int j=0; j<LINE_WIDTH;j++){
			this.lines[this.num][x][j%3] = el.substring(j,j+1);
			if(j%3 == 2){
				x++;
			}
		}
		this.num++;
		
	}
	

}
