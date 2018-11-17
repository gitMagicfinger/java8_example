package com.study.example.lambda;

/**
 * 기본적으로 람다식을 위한 인터페이스에서 추상 메소드는 단 하나여야 합니다.
 * 이 인터페이스는 람다식을 위한 것이다라는 표현을 위해 어노테이션 @FunctionalInterface을 사용합니다
 */
@FunctionalInterface
interface Func {
	public int calc(int a, int b);
}

public class Main01 {
	public static void main(String[] args) {
		Func add = (int a, int b) -> a + b;
		Func sub = (int a, int b) -> { return a - b; };
		int result = add.calc(1,2) + sub.calc(4, 2);
		System.out.println(result);
	}
	
	public int min(int x, int y) {
	    return x < y ? x : y;
	}
	// 람다 표현식 - (x, y) -> x < y ? x : y;
}

/**
 * 자바에서 람다 표현식을 작성할 때 유의해야 할 사항은 다음과 같습니다.
1. 매개변수의 타입을 추론할 수 있는 경우에는 타입을 생략할 수 있습니다.
2. 매개변수가 하나인 경우에는 괄호(())를 생략할 수 있습니다.
3. 함수의 몸체가 하나의 명령문만으로 이루어진 경우에는 중괄호({})를 생략할 수 있습니다. (이때 세미콜론(;)은 붙이지 않음)
4. 함수의 몸체가 하나의 return 문으로만 이루어진 경우에는 중괄호({})를 생략할 수 없습니다.
5. return 문 대신 표현식을 사용할 수 있으며, 이때 반환값은 표현식의 결괏값이 됩니다. (이때 세미콜론(;)은 붙이지 않음)


() -> {}                     // No parameters; result is void
() -> 42                     // No parameters, expression body
() -> null                   // No parameters, expression body
() -> { return 42; }         // No parameters, block body with return
() -> { System.gc(); }       // No parameters, void block body
() -> {
  if (true) { return 12; }
  else { return 11; }
}                          // Complex block body with returns
(int x) -> x+1             // Single declared-type parameter
(int x) -> { return x+1; } // Single declared-type parameter
(x) -> x+1                 // Single inferred-type parameter
x -> x+1                   // Parens optional for single inferred-type case
(String s) -> s.length()   // Single declared-type parameter
(Thread t) -> { t.start(); } // Single declared-type parameter
s -> s.length()              // Single inferred-type parameter
t -> { t.start(); }          // Single inferred-type parameter
(int x, int y) -> x+y      // Multiple declared-type parameters
(x,y) -> x+y               // Multiple inferred-type parameters
(final int x) -> x+1       // Modified declared-type parameter
(x, final y) -> x+y        // Illegal: can't modify inferred-type parameters
(x, int y) -> x+y          // Illegal: can't mix inferred and declared types
 */