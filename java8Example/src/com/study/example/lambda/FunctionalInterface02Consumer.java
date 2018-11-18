package com.study.example.lambda;

import java.util.function.Consumer;

public class FunctionalInterface02Consumer {

	public static void main(String[] args) {
		
		//############################################################################
		final Consumer<String> print1 = new Consumer<String>() {
			@Override
			public void accept(String value) {
				System.out.println(value);
			}
		};
		
		//############################################################################
		final Consumer<String> print2 = value -> System.out.println("Hello " + value);
			
		print1.accept("Hello World");
		print2.accept("World");
	}

}
