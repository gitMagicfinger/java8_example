package com.study.example.steamapi;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample04 {

	public static void main(String[] args) {
		// ############################################################################
		final int [] sum = {0};
		IntStream.range(0, 101)
				 .forEach(i -> sum[0] += i);
		System.out.println("                    sum (side-effect) : " + sum[0]);
		
		final int [] sum2 = {0};
		IntStream.range(0, 101)
				 .parallel()
				 .forEach(i -> sum2[0] += i);
		System.out.println("           paraller sum (side-effect) : " + sum2[0]);
		
		System.out.println("          stream sum (no side-effect) : " + 
				IntStream.range(0, 101)
		 		 		 .sum()
		);
		
		System.out.println("paraller stream sum  (no side-effect) : " + 
				IntStream.range(0, 101)
						 .parallel()
		 		 		 .sum()
		);
		
		
		// ############################################################################
		System.out.println("\nStream  #################################################"); 
		final long start =  System.currentTimeMillis();
		Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)
			  .stream()
			  .map( i -> {
				  try {
					  TimeUnit.SECONDS.sleep(1);
				  } catch(InterruptedException e) {
					  e.printStackTrace();
				  }
				  return i;
			  })
			  .forEach( i -> System.out.println(i));
		System.out.println("Time1 :" + (System.currentTimeMillis() - start)); 
		
		System.out.println("\nParalleal Stream ########################################"); 
		final long start2 =  System.currentTimeMillis();
		Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)
			  .parallelStream()
			  .map( i -> {
				  try {
					  TimeUnit.SECONDS.sleep(1);
				  } catch(InterruptedException e) {
					  e.printStackTrace();
				  }
				  return i;
			  })
			  .forEach( i -> System.out.println(i));
		System.out.println("Time2 :" + (System.currentTimeMillis() - start2)); 
		
		System.out.println("\nParalleal Stream ########################################");
		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "1");	//0부터 시작
		final long start3 =  System.currentTimeMillis();
		Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)
			  .parallelStream()
			  .map( i -> {
				  try {
					  TimeUnit.SECONDS.sleep(1);
				  } catch(InterruptedException e) {
					  e.printStackTrace();
				  }
				  return i;
			  })
			  .forEach( i -> System.out.println(i));
		System.out.println("Time2 :" + (System.currentTimeMillis() - start3)); 
	}

}
