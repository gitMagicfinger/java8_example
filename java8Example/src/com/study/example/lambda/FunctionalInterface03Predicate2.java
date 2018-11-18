package com.study.example.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalInterface03Predicate2 {

	public static void main(String[] args) {
		
		//############################################################################
		final Predicate<Integer> isPositive = i -> i > 0;
		List<Integer> numbers = Arrays.asList(-5,-4,-3,-2,-1,0,1,2,3,4,5);
		List<Integer> result = new ArrayList<Integer>();
		for(Integer num : numbers) {
			if ( isPositive.test(num) ) {
				result.add(num);
			}
		}
		System.out.println("0 보다 큰수 : " + result);
		
		
		final Predicate<Integer> lessThanThree = i -> i < 3;
		List<Integer> result2 = new ArrayList<Integer>();
		for(Integer num : numbers) {
			if ( lessThanThree.test(num) ) {
				result2.add(num);
			}
		}
		System.out.println("3 보다 작은수 : " + result2);
		//############################################################################
		
		
		System.out.println("0 보다 큰수 : " + filter(numbers, isPositive));
		System.out.println("0 보다 큰수 : " + filter(numbers, i -> i > 0));
		System.out.println("3 보다 작은수 : " + filter(numbers, lessThanThree));
		System.out.println("3 보다 작은수 : " + filter(numbers, i -> i < 3));
		//############################################################################
	}
	
	private static <T> List<T> filter(List<T> list, Predicate<T> filter) {
		List<T> result = new ArrayList<T>();
		for(T num : list) {
			if ( filter.test(num) ) {
				result.add(num);
			}
		}
		return result;
	}

}
