package com.study.example.lambda;

@FunctionalInterface
interface Compare {
	public int compareTo(int value1, int value2);
}

public class FunctionalInterfaceExample02 {
	
	public static void main(String[] args) {
		Compare compare = (i, j) -> i - j;
		exec(compare);
	}
	
	public static void exec(Compare compare) {
		int k = 10;
		int m = 20;
		int value = compare.compareTo(k, m);
		System.out.println(value);
	}

	
}