package com.learning.basicjava.sync;

class Miser extends Thread {
	
	private Long howMany;
	
	public Miser(Long howMany)
	{
		this.howMany = howMany;
	}
	
	@Override
	public void run () {
		for (int i = 0; i < howMany; i++)
		{
			synchronized (AccountSync.lock) //Add synchronized only where shared resource is used
			{
				AccountSync.balance ++;
			}
		}
	}
}


class SpendThrift extends Thread {
	private Long howMany;
	
	public SpendThrift(Long howMany)
	{
		this.howMany = howMany;
	}
	
	@Override
	public void run () {
		for (int i = 0; i < howMany; i ++) {
			synchronized (AccountSync.lock) //Add synchronization only around the shared resource  
			{
				AccountSync.balance --;
			}
		}
	}
}

public class AccountSync
{
	public static int balance = 0;
	public static final Object lock = new Object();
}
