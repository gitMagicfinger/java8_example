package com.study.example.steamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample02 {

	public static void main(String[] args) {
		// toList() ###################################################################
		System.out.println("collect(toList()) \t: " + 
			Stream.of(1,2,3,3,5,5)
				.filter(i -> i > 2)
				.map(i -> i * 1)
				.map(i -> "#" + i)
				.collect(Collectors.toList())
		);
		
		// toSet() ####################################################################
		System.out.println("collect(toSet()) \t: " + 
			Stream.of(1,2,3,3,5,5)
				.filter(i -> i > 2)
				.map(i -> i * 1)
				.map(i -> "#" + i)
				.collect(Collectors.toSet())
		);
		
		// joining(", ") ##############################################################
		System.out.println("collect(joining1()) \t: " + 
			Stream.of(1,2,3,3,5,5)
				.filter(i -> i > 2)
				.map(i -> i * 1)
				.map(i -> "#" + i)
				.collect(Collectors.joining(", "))
		);
		
		// joining(", ", "[", "]") ####################################################
		System.out.println("collect(joining2()) \t: " + 
			Stream.of(1,2,3,3,5,5)
				.filter(i -> i > 2)
				.map(i -> i * 1)
				.map(i -> "#" + i)
				.collect(Collectors.joining(", ", "[", "]"))	
		);

		// distinct() joining(", ", "[", "]") #########################################
		System.out.println("distinct().collect(joining3()) \t: " + 
			Stream.of(1,2,3,3,5,5)
				.filter(i -> i > 2)
				.map(i -> i * 1)
				.map(i -> "#" + i)
				.distinct()
				.collect(Collectors.joining(", ", "[", "]"))	
		);
		
		// distinct() #################################################################
		System.out.println("distinct().collect(toList()) \t: " + 
			Stream.of(1,2,3,3,5,5)
				.filter(i -> i > 2)
				.map(i -> i * 1)
				.map(i -> "#" + i)
				.distinct()
				.collect(Collectors.toList())	
		);
		
		// 127 find ###################################################################
		final Integer integer127 = 127;
		System.out.println("Find127  \t: " + 
			Stream.of(1,2,3,4,5,127)
				.filter(i -> i == integer127)
				.findFirst()
		);
		
		// 128 find ###################################################################
		final Integer integer128 = 128;
		System.out.println("Find128  \t: " + 
			Stream.of(1,2,3,4,5,128)
				.filter(i -> i == integer128)
				.findFirst()
		);
		
		// equals #####################################################################
		System.out.println("Find128.equals()  \t: " + 
			Stream.of(1,2,3,4,5,128)
				.filter(i -> i.equals(128))
				.findFirst()
		);
		
		// count ######################################################################
		System.out.println("filter(i -> i > 3).count()  \t: " + 
			Stream.of(1,2,3,4,5)
				.filter(i -> i > 3)
				.count()
		);
		
		// forEach ####################################################################
		final List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		for(Integer i : numbers) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		Arrays.asList(1,2,3,4,5,6,7,8,9,10)
		 	.forEach(i -> System.out.print(i + " "));
		
	}

}
