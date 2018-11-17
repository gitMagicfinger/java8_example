package com.study.example.optional;

import java.util.Optional;

public class Main01 {

	public static void main(String[] args) {
		String text = getText();
		int length;
		if (text != null) {
			length = text.length();
		} else {
			length = 0;
		}		
		System.out.println("length : " + length);
		
		/* Optional Example */
		length = Optional.ofNullable(getText()).map(String::length).orElse(0);		
		System.out.println("length : " + length);
	}
	
	public static String getText() {
		return "java8";
	}
}
