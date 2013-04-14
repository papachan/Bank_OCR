package com.androidda.katabankocr;

import org.apache.commons.lang3.StringUtils;

public class AccountCheck {


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

}
