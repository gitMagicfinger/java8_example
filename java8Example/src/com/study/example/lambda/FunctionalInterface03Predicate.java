package com.study.example.lambda;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class FunctionalInterface03Predicate {

	public static void main(String[] args) {
		
		//############################################################################
		final Predicate<Integer> isPositive = new Predicate<Integer>() {
			@Override
			public boolean test(Integer value) {
				return value > 0 ? true : false;
			}
			
		};
		
		//############################################################################
		final Predicate<Integer> isPositive2 = i -> i > 0;
			
		System.out.println("result : " + isPositive2.test(10));
		System.out.println("result : " + isPositive2.test(0));
		System.out.println("result : " + isPositive2.test(-10));
	}

}
