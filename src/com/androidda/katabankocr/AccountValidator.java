package com.androidda.katabankocr;

public class AccountValidator {
	
	private Integer result = null;
	
	private static final String CERO = " _ " + "| |" + "|_|";
	private static final String UNO = "   " + "  |" + "  |";
	private static final String DOS = " _ " + " _|" + "|_ ";
	private static final String TRES = " _ " + " _|" + " _|";
	private static final String CUATRO = "   " + "|_|" + "  |";
	private static final String CINCO = " _ " + "|_ " + " _|";
	private static final String SEIS = " _ " + "|_ " + "|_|";
	private static final String SIETE = " _ " + "  |" + "  |";
	private static final String OCHO = " _ " + "|_|" + "|_|";
	private static final String NUEVE = " _ " + "|_|" + " _|";
	
	public Boolean isValidNumber (String in){
		result = null;
		if(in.equals(CERO)){
			setIndentified_number(0);
		}else if(in.equals(UNO)) {
			setIndentified_number(1);
		}else if(in.equals(DOS)) {
			setIndentified_number(2);
		}else if(in.equals(TRES)) {
			setIndentified_number(3);
		}else if(in.equals(CUATRO)) {
			setIndentified_number(4);
		}else if(in.equals(CINCO)) {
			setIndentified_number(5);
		}else if(in.equals(SEIS)) {
			setIndentified_number(6);
		}else if(in.equals(SIETE)) {
			setIndentified_number(7);
		}else if(in.equals(OCHO)) {
			setIndentified_number(8);
		}else if(in.equals(NUEVE)) {
			setIndentified_number(9);
		}
		if(result != null){
			return true;
		}
		return false;
	}
	public Integer getIndentified_number() {
		return result;
	}
	private void setIndentified_number(int number) {
		result = number;
	}

}