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
		
//		FunctionalInterface �� �߻�޼ҵ尡 generic�̸� ����� �� ����
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