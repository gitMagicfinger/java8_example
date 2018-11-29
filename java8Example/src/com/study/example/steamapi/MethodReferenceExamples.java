package com.study.example.steamapi;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MethodReferenceExamples {
	
	public static void main(String[] args) {
		// ############################################################################
		Arrays.asList(1,2,3,4,5)
			  .forEach(i -> System.out.println(i));
		
		Arrays.asList(1,2,3,4,5)
			  .forEach(System.out::println);
	}

}
