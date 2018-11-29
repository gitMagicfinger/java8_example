package com.study.example.steamapi;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class HigherOrderFunctionExamples {
	
	public static void main(String[] args) {
		// ############################################################################
		final Function<Function<Integer, String>, String> f = g -> g.apply(10);
		System.out.println(f.apply(i -> "#" + i));
		
		// ############################################################################
		final Function<Integer, Function<Integer, Integer>> f2 = i -> (i2 -> i + i2);
		System.out.println(f2.apply(1).apply(9));
		
		// ############################################################################
		final List<Integer> list = Arrays.asList(1,2,3,4,5);
		final List<String> mappedList = map(list, i -> "#" + i);
		System.out.println(mappedList);
		
		
		// ############################################################################
		System.out.println(
			list.stream()
				.map(i -> "#" + i)
				.collect(toList())
				);
		
		// ############################################################################
		Function<Integer, Function<Integer, Function<Integer, Integer>>> f3 =
				i1 -> i2 -> i3 -> i1 + i2 + i3;
		System.out.println( f3.apply(1).apply(2).apply(3) );
		
		final Function<Integer, Function<Integer, Integer>> plus1 = f3.apply(1);
		final Function<Integer, Integer> plus2 = plus1.apply(2);
		final Integer plus3 = plus2.apply(3);
		System.out.println(plus3);
	}
	
	private static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
		final List<R> result = new ArrayList<>();
		for(final T t : list) {
			result.add(mapper.apply(t));
		}
		return result;
	}
	

}
