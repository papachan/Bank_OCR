package com.androidda.katabankocr;

public class AccountValidator {
	
	private int _indentified_number;
	
	private static final String CERO = " _ | ||_|";
	private static final String UNO = "     |  |";
	private static final String DOS = " _  _||_ ";
	private static final String TRES = " _  _| _|";
	private static final String CUATRO = "   |_|  |";
	private static final String CINCO = " _ |_  _|";
	private static final String SEIS = " _ |_ |_|";
	private static final String SIETE = " _   |  |";
	private static final String OCHO = " _ |_||_|";
	private static final String NUEVE = " _ |_| _|";
	
	public AccountValidator (){
		
	}
	public Boolean isValidNumber (String in){
		if(in.equals(CERO)){
			this.setIndentified_number(0);
		}else if(in.equals(UNO)) {
			this.setIndentified_number(1);
		}else if(in.equals(DOS)) {
			this.setIndentified_number(2);
		}else if(in.equals(TRES)) {
			this.setIndentified_number(3);
		}else if(in.equals(CUATRO)) {
			this.setIndentified_number(4);
		}else if(in.equals(CINCO)) {
			this.setIndentified_number(5);
		}else if(in.equals(SEIS)) {
			this.setIndentified_number(6);
		}else if(in.equals(SIETE)) {
			this.setIndentified_number(7);
		}else if(in.equals(OCHO)) {
			this.setIndentified_number(8);
		}else if(in.equals(NUEVE)) {
			this.setIndentified_number(9);
		}
		return true;
	}
	public int getIndentified_number() {
		return _indentified_number;
	}
	public void setIndentified_number(int number) {
		this._indentified_number = number;
	}

}
