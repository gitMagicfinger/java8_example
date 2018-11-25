package com.study.example.steamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample01 {

	public static void main(String[] args) {
		// ############################################################################
		IntStream.range(1, 10).forEach(i -> System.out.print(i + " " ));
		System.out.println("");
		IntStream.rangeClosed(1, 10).forEach(i -> System.out.print(i + " " ));
		
		// ############################################################################
		System.out.println("\n");
		Stream.of(1,2,3,4,5)
			.forEach(i -> System.out.print(i + " "));
			
		// ############################################################################
		System.out.println("\n");
		final List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		Integer result = null;
		for(final Integer number : numbers) {
			if ( number > 3 &&  number < 9 ) {
				final Integer newNumber = number * 2;
				if ( newNumber > 10) {
					result = newNumber;
					break;
				}
			}
		}
		System.out.println("Old Result : " + result);
		
		System.out.println("New Result : " + numbers.stream()
			.filter(x -> x > 3)
			.filter(x -> x < 9)
			.map(x -> x * 2)
			.filter(x -> x > 10)
			.findFirst());
	}

}
