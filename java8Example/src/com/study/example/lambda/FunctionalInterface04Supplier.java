package com.study.example.lambda;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class FunctionalInterface04Supplier {

	public static void main(String[] args) {
		
		//############################################################################
		final Supplier<String> helloSupplier = () -> "Hello";
		System.out.println(helloSupplier.get());
		
		//############################################################################
		long start = System.currentTimeMillis();
		printifValidIndex(0, getVeryExpensiveValue());
		printifValidIndex(1, getVeryExpensiveValue());
		printifValidIndex(-1, getVeryExpensiveValue());
		System.out.println("Time : " + ((System.currentTimeMillis() - start) / 1000) + "seconds.");
		
		
		start = System.currentTimeMillis();
		printifValidIndex(0, () -> getVeryExpensiveValue());
		printifValidIndex(1, () -> getVeryExpensiveValue());
		printifValidIndex(-1, () -> getVeryExpensiveValue());
		System.out.println("Time : " + ((System.currentTimeMillis() - start) / 1000) + "seconds.");
		
	}
	
	private static String getVeryExpensiveValue() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Test";
	}
	
	private static void printifValidIndex(int number, String value) {
		if ( number >= 0  ) {
			System.out.println("The value is " + value);
		} else {
			System.out.println("Invaild");
		}
	}
	
	private static void printifValidIndex(int number, Supplier<String> valueSupplier) {
		if ( number >= 0  ) {
			System.out.println("The value is " + valueSupplier.get());
		} else {
			System.out.println("Invaild");
		}
	}
		

}
