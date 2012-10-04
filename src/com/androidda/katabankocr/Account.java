package com.androidda.katabankocr;

public final class Account {
	
	private String accountNumber;
	
	public Account(String account_number) {
		this.accountNumber = account_number;
	}
	
	public Boolean isValidAccount() {
		return true;
	}
	
	public String getAccountNumber() {
		return this.accountNumber;
	}

}
