package com.learning.basicjava.nosync;

public class RaceConditionNoSync
{
	/* Ideally the resuls should be 0 */
	public static void main(String[] args)
	{
		Miser miser = new Miser(1000000);
		SpendThrift spendThrift = new SpendThrift(1000000);
		
		miser.start();
		spendThrift.start();

		
		try{
			miser.join(); //Have the main thread Wait until miser threads completes. Main thread is doing wait but not busy wait.
			spendThrift.join();//Have the main thread Wait until miser threads completes 
			
		}catch (Exception e){
			e.printStackTrace(System.err);
		}
		
		//print the shared resource value
		System.out.println("AccountSync : balance " + AccountNoSync.balance);
	}
}
