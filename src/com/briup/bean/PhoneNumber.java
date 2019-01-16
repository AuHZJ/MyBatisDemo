package com.briup.bean;

import java.io.Serializable;

// 021-3359-3216
public class PhoneNumber implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String countryCode;
	private String stateCode;
	private String number;

	public PhoneNumber() {
	}
	
	// 021-3359-3216 ----> PhoneNumber
	public PhoneNumber(String str) {
		String[] number = str.split("[-]");
		this.countryCode = number[0];
		this.stateCode = number[1];
		this.number = number[2];
		
	}
	
	// 021,3359,3216
	public PhoneNumber(String countryCode, String stateCode, String number) {
		this.countryCode = countryCode;
		this.stateCode = stateCode;
		this.number = number;
	}

	//PhoneNumber ---> 021-3359-3216
	public String getAsString() {
		return countryCode + "-" + stateCode + "-" + number;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return countryCode + "-" + stateCode + "-" + number;
	}
	
}
