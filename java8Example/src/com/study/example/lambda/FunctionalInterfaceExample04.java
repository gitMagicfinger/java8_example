package com.study.example.lambda;

import java.math.BigDecimal;

public class FunctionalInterfaceExample04 {

	public static void main(String[] args) {
		BigDecimalToCurrency bigDecimalToCurrency = bd -> "$" + bd.toString();
		System.out.println("value = " + bigDecimalToCurrency.toCurrency(new BigDecimal("120.00")));
		
		final InvaildFunctionalInterface anonymousClass = new InvaildFunctionalInterface() {
			@Override
			public <T> String makeString(final T value) {
				return value.toString();
			}
		};
		
		System.out.println("anonymous class : " + anonymousClass.makeString(123));
		
//		FunctionalInterface 의 추상메소드가 generic이면 사용할 수 없다
//		final InvaildFunctionalInterface invaildFunctionalInterface = value -> value.toString();
//		System.out.println("anonymous class : " + invaildFunctionalInterface.makeString(123));
	}
}


@FunctionalInterface
interface BigDecimalToCurrency {
	String toCurrency(BigDecimal value);
}

@FunctionalInterface
interface InvaildFunctionalInterface {
	<T> String makeString(T value);
}