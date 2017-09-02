package com.learning.basicjava.callableThread;

import java.util.concurrent.Callable;

public class CallableBasicCounter implements Callable<Long>
{
	private final long count;
	
	public CallableBasicCounter(long count)
	{
		this.count = count;
	}
	
	@Override
	public Long call() throws Exception
	{
		long sum = 0;
		
		for (int i = 0; i < count; i ++){
			sum += i;
		}
		System.out.println("Thread Name - " + Thread.currentThread().getName() + " : " + sum);
		
		return sum;
	}	
	
}
