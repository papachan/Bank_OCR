package com.androidda.katabankocr;

import org.apache.commons.lang3.StringUtils;

public final class Account {
	
	private String accountNumber;
	
	public static final String ERROR_OK = "";
	public static final String OPTIONS_AMB = " AMB";
	public static final String ERR_ILL = " ILL";
	public static final String ERR_ERR = " ERR";
	
	
	public Account(String account_number) {
		this.accountNumber = account_number;
	}
	public Account(String[] value) {
		accountNumber = StringUtils.join(value, "");
	}
	
	public boolean isValidAccount() {
		return !(accountNumber.indexOf('?') != -1);
	}
	
	public void add(String end){
		accountNumber += end;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}

}