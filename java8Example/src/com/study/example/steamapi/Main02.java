package com.study.example.steamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main02 {

	public static void main(String[] args) {
		//############################################################################
		final List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		final String result = numbers.stream()
									 .map(String::valueOf)
									 .collect(Collectors.joining(" : "));
		System.out.println(result);		
		//############################################################################
		
		//############################################################################
		Arrays.asList("a1", "a2", "a3")
			.stream()
			.findFirst()
			.ifPresent(System.out::println); // a1
		//############################################################################
		
		//############################################################################
		Stream.of("a1", "a2", "a3")
			.findFirst()
	    	.ifPresent(System.out::println);  // a1
		//############################################################################
		
		//############################################################################
		IntStream.range(1, 4)
			.forEach(System.out::println);
		//############################################################################
		
		//############################################################################
		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
		myList.stream()
		      .filter(s -> s.startsWith("c"))
		      .map(String::toUpperCase)
		      .sorted()
		      .forEach(System.out::println);	// C1 C2
		//############################################################################
	}

}
