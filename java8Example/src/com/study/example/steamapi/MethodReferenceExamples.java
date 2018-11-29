package com.study.example.steamapi;

import java.util.Arrays;

public class MethodReferenceExamples {
	
	public static void main(String[] args) {
		// ############################################################################
		Arrays.asList(1,2,3,4,5)
			  .forEach(i -> System.out.println(i));
		
		Arrays.asList(1,2,3,4,5)
			  .forEach(System.out::println);
	}
 
}
