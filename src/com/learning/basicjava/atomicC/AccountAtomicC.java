package com.learning.basicjava.atomicC;

import java.util.concurrent.atomic.AtomicInteger;

class Miser extends Thread {
	private int howMany;
	
	public Miser(int howMany)
	{
		this.howMany = howMany;
	}
	
	@Override
	public void run () {
		for (int i = 0; i < howMany; i ++) {
			AccountAtomicC.balance.incrementAndGet();
		}
	}
}

class SpendThrift extends Thread {
	private int howMany;
	
	public SpendThrift(int howMany)
	{
		this.howMany = howMany;
	}
	
	@Override
	public void run () {
		for (int i = 0; i < howMany; i ++) {
			AccountAtomicC.balance.decrementAndGet();
		}
	}
}


public class AccountAtomicC
{
	//All the methods in AtomicInteger are synchronized. Lock is applied on self - this. Hence when a thread executes incrementAndGet no other thread can execute decrementAndGet.
	public static AtomicInteger balance = new AtomicInteger();
}
