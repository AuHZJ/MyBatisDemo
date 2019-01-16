package com.briup.test;

public class StringSplitTest {
	
	public static void main(String[] args) {
		
		String phoneNumber = "021-3758-9910";
		String[] strings = phoneNumber.split("-");
		for (int i = 0; i < strings.length; i++) {
			String str = strings[i];
			System.out.println("strings["+i+"]="+str);
		}
	}
}
