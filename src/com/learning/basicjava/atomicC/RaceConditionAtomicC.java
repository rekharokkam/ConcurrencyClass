package com.learning.basicjava.atomicC;

public class RaceConditionAtomicC
{
	public static void main(String[] args)
	{
		Miser miser = new Miser (1000);
		SpendThrift spendThrift = new SpendThrift (1000);
		
		miser.start();
		spendThrift.start();
		
		try {
			miser.join(); //main thread waits until miser thread completes
			spendThrift.join();//main thread waits until spendThrift completes.
		}catch (InterruptedException exception) {
			exception.printStackTrace(System.err);
		}
System.out.println("account balance : " + AccountAtomicC.balance.get());		
	}
}
