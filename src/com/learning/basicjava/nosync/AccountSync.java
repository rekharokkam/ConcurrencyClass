package com.learning.basicjava.nosync;


class Miser extends Thread{
	
	private int howMany;
	
	Miser (int howMany){
		this.howMany = howMany;
	}
	
	@Override
	public void run () {
		for (int i = 0; i < howMany; i ++){
			AccountSync.balance++;
		}
	}
}

class SpendThrift extends Thread {
	
	private int howMany;
	
	SpendThrift(int howMany){
		this.howMany = howMany;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < howMany; i ++){
			AccountSync.balance--;
		}
	}
}

public class AccountSync
{
	public static int balance = 0;//Common Shared resource
}
