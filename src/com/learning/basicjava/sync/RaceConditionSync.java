package com.learning.basicjava.sync;

public class RaceConditionSync
{
	public static void main(String[] args)
	{
		Miser miser = new Miser(100_000L);
		SpendThrift spendThrift = new SpendThrift (100_000_000L);
		
		miser.start();
		spendThrift.start();
		
		try {
			miser.join(); //main thread waits until miser thread completes
			spendThrift.join();//main thread waits until spendThrift completes.
		}catch (InterruptedException exception) {
			exception.printStackTrace(System.err);
		}
		
		System.out.println("Final account balance after looping : "+ AccountSync.balance);
	}
}
