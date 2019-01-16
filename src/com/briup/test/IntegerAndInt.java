package com.briup.test;

public class IntegerAndInt {
	public static void main(String[] args) {
		
		int a=28;
		int b=28;
		
		System.out.println(a==b);//true
		
		Integer c=28;
		Integer d=28;
		
		System.out.println(c==d);//true
		
		int m=128;
		int n=128;
		System.out.println(m==n);//true
		//[-128,127]
		Integer x=128;
		Integer y=128;
		
		System.out.println(x==y);//?
		System.out.println(x);
		System.out.println(y);
	}
}
