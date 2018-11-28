package com.study.example.steamapi;

public class ClosureExample01 {

	public static void main(String[] args) {
		// ############################################################################
		int number = 100;		// Effectively Final
		
		//1.
		System.out.println("Anonymous Class");
		final Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println(number);
			}
		};
		runnable.run();
		
		//2.
		System.out.println("Lambda");
		Runnable runnable2 = () -> System.out.println(number);
		runnable2.run();
		
		//3.
		testClosure("Anonymous Class", new Runnable() {
			@Override
			public void run() {
				System.out.println(number);
			}
		});
		
		//4.
		testClosure("Lambda Expression", () -> System.out.println(number));
	}
	
	private static void testClosure(final String name, final Runnable runnable) {
		System.out.println("Start " + name + " : ");
		runnable.run();
		System.out.println("---------------------------------------------");
		
	}

}
