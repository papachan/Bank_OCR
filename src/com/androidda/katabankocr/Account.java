package com.androidda.katabankocr;

import org.apache.commons.lang3.StringUtils;

public final class Account {
	
	private String accountNumber;
	
	public Account(String account_number) {
		this.accountNumber = account_number;
	}
	public Account(String[] value) {
		accountNumber = StringUtils.join(value, "");
	}
	
	public Boolean isValidAccount() {
		return (accountNumber.indexOf('?') != -1);
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}

}