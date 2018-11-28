package com.study.example.steamapi;

public class ClosureExample02 {
	private int number = 999;
	
	public static void main(String[] args) {
		//new ClosureExample02().test1();		
		//new ClosureExample02().test2();
		new ClosureExample02().test3();
	}
	
	@Override
	public String toString() {
		return new StringBuilder("ClosureExample {") 
			  .append("number = ")
			  .append(number)
			  .append("}")
			  .toString();
	}
	
	public static<T> String toString(T value) {
		return "The value is : " + String.valueOf(value);
	}
	
	private void test1() {
		// ############################################################################
		int number = 100;		// Effectively Final
		
		//1.
		testClosure("Anonymous Class", new Runnable() {
			@Override
			public void run() {
				System.out.println(ClosureExample02.this.toString());
			}
		});
		
		//2.
		//testClosure("Lambda Expression", () -> System.out.println(number));
		testClosure("Lambda Expression", () -> System.out.println(this.toString()));
	}
	
	private void test2() {
		// ############################################################################
		//1.
		testClosure("Anonymous Class", new Runnable() {
			@Override
			public void run() {
				System.out.println("this.toString() : " + this.toString());
			}
		});
		
		//2.
		testClosure("Anonymous Class", new Runnable() {
			@Override
			public void run() {
				System.out.println("ClosureExample.this.toString() : " + ClosureExample02.this.toString());
			}
		});
		
		//3.
		testClosure("Lambda Expression", () -> System.out.println("this.toString() : " + this.toString()));
	}
	
	private void test3() {
		// ############################################################################
		//1.
		testClosure("Anonymous Class", new Runnable() {
			@Override
			public void run() {
				System.out.println("ClosureExample.this.toString() : " + ClosureExample02.this.toString("Test1")); 
				//System.out.println("toString() : " + toString("Test")); 		// -> toString() Á¢±Ù ¾ÈµÊ
			}
		});
		
		//2.
		testClosure("Lambda Expression", () -> System.out.println("toString() : " + toString("Test2")));
	}
	
	private void test4() {
		// ############################################################################
		int number = 100;		// Effectively Final
		
		//1.
		testClosure("Anonymous Class", new Runnable() {
			@Override
			public void run() {
				int number = 50; 
				System.out.println(number);
			}
		});
		
		//2.
		//testClosure("Lambda Expression", () -> System.out.println(number));
		testClosure("Lambda Expression", () -> {
			//int number = 50;		// Compile-time Error
			System.out.println(number);
		});
	}
	
	
	
	private static void testClosure(final String name, final Runnable runnable) {
		System.out.println("Start " + name + " : ");
		runnable.run();
		System.out.println("---------------------------------------------");
		
	}

}
