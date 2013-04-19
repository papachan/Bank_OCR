package com.androidda.katabankocr;

import org.apache.commons.lang3.StringUtils;

import com.androidda.utils.StringConcatUtil;

public final class Account {
	
	private String accountNumber;
	
	private String transformed_number;
	
	public static final String ERROR_OK = "";
	public static final String OPTIONS_AMB = " AMB";
	public static final String ERR_ILL = " ILL";
	public static final String ERR_ERR = " ERR";
	
	public Account(String account_number) {
		this.accountNumber = account_number;
		transformed_number = accountNumber;
	}
	
	public Account(String[] value) {
		accountNumber = StringUtils.join(value, "");
		transformed_number = accountNumber;
	}
	
	public boolean isValidAccount() {
		return !(accountNumber.indexOf('?') != -1);
	}

	public void setAccountNumber(String account){
		accountNumber = account;
	}
	
	public void append(String end){
		accountNumber = accountNumber.concat(end);
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public String getTransformedNumber() {
		return transformed_number;
	}

	public void setTransformedNumber(String options) {
		this.transformed_number = StringConcatUtil.concat(this.transformed_number, " [", options, "]");
	}

}