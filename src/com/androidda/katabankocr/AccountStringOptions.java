package com.androidda.katabankocr;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.androidda.utils.StringConcatUtil;

public final class AccountStringOptions{
	
	public static Pattern pattern = Pattern.compile("/*9|5|0|1");
//	public static Pattern pattern = Pattern.compile("/*2"); // TEST
	
	private final String account_option;
	
	private final String[] rules = { "0,1", "1,7", "5,9", "5,6", "9,8" };
	
	private int cant_options;
	
	public static int repeatedNumbersRegExp  (String cad, Pattern p) {
		ArrayList<Integer> pos = new ArrayList<Integer>();
		Matcher m = p.matcher(cad);
		while (m.find()) {
			pos.add(m.start());
		}
		return pos.size();
	}

	public AccountStringOptions (String cad) {
		this.account_option = cad;
//		System.out.println("rules:" + StringUtils.join(rules,"   "));
	}
	public String getOptions() {
		int repeated_time = 0;
		
		repeated_time = repeatedNumbersRegExp(this.account_option, pattern);

		System.out.println("Repeated times:" + repeated_time);
		
		ArrayList<String> options = new ArrayList<String>();
		
		for (int k = 0; k < rules.length; k++) {
//			String c = rules[k].split(",")[0];
//			System.out.println("busca:" + c);
			ArrayList<Integer> all_positions = new ArrayList<Integer>();
			for (int i = -1; (i = account_option.indexOf(rules[k].split(",")[0], i + 1)) != -1; ) {
				all_positions.add(i);
			}
			if(!all_positions.isEmpty()) {
				for (int l = 0; l < all_positions.size(); l++) {
					String acc = replaceCurrentAccount(all_positions.get(l), rules[k].split(",")[1]);
					// CheckSum new account number
					if(AccountParser.checksum(acc)){
						options.add(acc);
					}
					
				}
			}
		}
			
		setCantOptions(options.size());
		
		
		
		
		return StringUtils.join(options, ",");
//		return options;
		
	}
	private String replaceCurrentAccount(int pos, String replaceBy) {
		return StringConcatUtil.concat(this.account_option.substring(0,pos),
				replaceBy, 
				this.account_option.substring(pos+1));
	}
	
	public int getCantOptions() {
		return cant_options;
	}

	public void setCantOptions(int cant_options) {
		this.cant_options = cant_options;
	}

	public String toString() {
		return account_option;
	}

}
