package com.learning.basicjava.basic;

public class UserDaemon
{
	public static void main(String[] args)
	{
		System.out.println("Main thread started........");
		
		Thread createdThread = new Thread ("MyThread"){
			
			@Override
			public void run (){
				System.out.println("Created thread running ");
				while (true){
					System.out.println("Putting thread to sleep");
					try{
						Thread.sleep(1000);//Thread refers to the current thread running
					}catch (InterruptedException exception){
						System.out.println("Created Thread aWakes as its sleep is interrupted");
					}
				}
			}
		};
		
		createdThread.setDaemon(true);
		
		createdThread.start();
		
		System.out.println("Main Thread is exiting........");
	}
}
