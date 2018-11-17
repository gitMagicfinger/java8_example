package com.study.example.lambda;

/**
 * �⺻������ ���ٽ��� ���� �������̽����� �߻� �޼ҵ�� �� �ϳ����� �մϴ�.
 * �� �������̽��� ���ٽ��� ���� ���̴ٶ�� ǥ���� ���� ������̼� @FunctionalInterface�� ����մϴ�
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
	// ���� ǥ���� - (x, y) -> x < y ? x : y;
}

/**
 * �ڹٿ��� ���� ǥ������ �ۼ��� �� �����ؾ� �� ������ ������ �����ϴ�.
1. �Ű������� Ÿ���� �߷��� �� �ִ� ��쿡�� Ÿ���� ������ �� �ֽ��ϴ�.
2. �Ű������� �ϳ��� ��쿡�� ��ȣ(())�� ������ �� �ֽ��ϴ�.
3. �Լ��� ��ü�� �ϳ��� ��ɹ������� �̷���� ��쿡�� �߰�ȣ({})�� ������ �� �ֽ��ϴ�. (�̶� �����ݷ�(;)�� ������ ����)
4. �Լ��� ��ü�� �ϳ��� return �����θ� �̷���� ��쿡�� �߰�ȣ({})�� ������ �� �����ϴ�.
5. return �� ��� ǥ������ ����� �� ������, �̶� ��ȯ���� ǥ������ �ᱣ���� �˴ϴ�. (�̶� �����ݷ�(;)�� ������ ����)


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