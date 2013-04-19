package com.androidda.katabankocr;

public class AccountValidator {
	
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
	
	public boolean isValidNumber (String in) {
		if(in.equals(CERO) 
			|| in.equals(UNO)
			|| in.equals(DOS)
			|| in.equals(TRES)
			|| in.equals(CUATRO)
			|| in.equals(CINCO)
			|| in.equals(SEIS)
			|| in.equals(SIETE)
			|| in.equals(OCHO)
			|| in.equals(NUEVE)
			){
			return true;
		}
		return false;
	}
	public static String getIndentifiedNumber (String in) {
		if(in.equals(CERO)){
			return "0";
		}else if(in.equals(UNO)) {
			return "1";
		}else if(in.equals(DOS)) {
			return "2";
		}else if(in.equals(TRES)) {
			return "3";
		}else if(in.equals(CUATRO)) {
			return "4";
		}else if(in.equals(CINCO)) {
			return "5";
		}else if(in.equals(SEIS)) {
			return "6";
		}else if(in.equals(SIETE)) {
			return "7";
		}else if(in.equals(OCHO)) {
			return "8";
		}else if(in.equals(NUEVE)) {
			return "9";
		}
		return "?";
	}


}
