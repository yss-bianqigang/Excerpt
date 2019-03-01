package org.bian.com;

import java.util.Random;

public class RandomTest {
	public static void main(String[] args){
		Random rd = new Random();
		System.out.println(rd.nextInt(3));
		char a1 = CharCreate();
		char a2 = CharCreate();
		char a3 = CharCreate();
		char a4 = CharCreate();
		char a5 = CharCreate();
		char a6 = CharCreate();
		System.out.println((int)'中');
		System.out.println((char)20020);
		System.out.println((char)20019);
		System.out.println((char)20018);
		System.out.println((char)20016);
		System.out.println((char)20015);
		System.out.println((char)20014);
		System.out.println((char)20013);
		System.out.println(""+a1+a2+a3+a4+a5+a6);
	}
	public static char CharCreate(){
//		System.out.println((char)('中'+Math.random()*('国'-'中'+1))); 
//		return (char)('a'+Math.random()*('z'-'a'+1));
		return (char)('中'+Math.random()*(20020-'中'+1));
	}
}
