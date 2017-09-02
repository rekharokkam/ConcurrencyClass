package com.learning.basicjava.basic;

public class BasicCounter implements Runnable
{
	private final long count;
	
	public BasicCounter(long count)
	{
		this.count = count;
	}
	
	@Override
	public void run (){
		long sum = 0;
		
		for (int i = 0; i < count; i ++){
			sum += 1;
		}
		System.out.println(Thread.currentThread().getName() + " : " + sum);
	}
}
