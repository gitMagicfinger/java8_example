package com.study.example.lambda;

import java.util.function.Function;

public class FunctionalInterface01Function {

	public static void main(String[] args) {
		
		//############################################################################
		Function<String, Integer> toInt1 = new Function<String, Integer>() {
			@Override
			public Integer apply(final String value) {
				return Integer.parseInt(value);
			}
		};
		
		//############################################################################
		Function<String, Integer> toInt2 = (final String value) -> {
			return Integer.parseInt(value);
		};		
		
		//############################################################################
		Function<String, Integer> toInt3 = value -> 
			Integer.parseInt(value)
		;
			
			
		final Integer number = toInt1.apply("199");
		System.out.println("number : " + number);
	}

}
