package com.learning.basicjava.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunBasicCounter2
{
	public static void main(String[] args)
	{
		System.out.println("Main method starting ......");
		
		final int howManyCounters = 100;//Creating 100 threads
		
		ExecutorService executorService = Executors.newFixedThreadPool(10);// We are telling assign 10 threads to the Pool
		
		for (int i = 0; i < howManyCounters; i ++){
			Runnable runnable = new BasicCounter(10_000_00L);
			/*
			 * Executes the given command at some time in the future. 
			 * The command may execute in a new thread, in a pooled thread, or in the calling thread, at the discretion of the Executor implementation.
			 */
			executorService.execute(runnable);
		}
		executorService.shutdown();//// accept no more Runnables
		
		while (!executorService.isTerminated()){
			//Just adding some busy wait to the main method
		}
		System.out.println("Main method exiting .......");
	}
}
