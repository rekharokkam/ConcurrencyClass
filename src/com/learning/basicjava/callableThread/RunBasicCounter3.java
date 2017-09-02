package com.learning.basicjava.callableThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunBasicCounter3
{
	public static void main(String[] args)
	{
		final int howManyThreads = 100;
		Long totalSum = 0l;
		
		List<Future<Long>> list = new ArrayList<Future<Long>>();
		
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < howManyThreads; i ++){
			Callable<Long> counter = new CallableBasicCounter(100_000L);
			Future<Long> result = executorService.submit(counter);
			
			list.add(result);
		}
		
//		executorService.shutdown();//This method tells the service not to receive any more tasks. If this method is not invoked then Program never terminates.
		for (Future<Long> future : list){
			try{
				totalSum += future.get();//This is a blocking get. It waits until the future task is completed. Bad idea to use this method instead use timed Bloking
			}catch (InterruptedException e){
				System.err.println("An Interrupted Exception was throw : ");
				e.printStackTrace(System.err);
			}catch (ExecutionException e1){
				System.err.println("An Execution Exception was throw : ");
				e1.printStackTrace(System.err);
			}
		}
		
		System.out.println("Total Sum of all the tasks/jobs : " + totalSum);
	}
}
