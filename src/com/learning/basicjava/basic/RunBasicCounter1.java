package com.learning.basicjava.basic;

import java.util.ArrayList;
import java.util.List;

/*
 * This class manually manages the Threads in a pool kind of structure
 */
public class RunBasicCounter1
{

	public static void main(String[] args)
	{
		System.out.println("Main thread starting");
		List<Thread> threads = new ArrayList<Thread>(); //For book keeping
		
		final int howManyCounters = 32;//How many worker threads to span up
		
		for (int i = 0; i < howManyCounters; i ++){
			Runnable task = new BasicCounter(10_000_000L + i);
			Thread threadTask = new Thread (task);
			
			threadTask.setName("T" + (i + 1));
			
			threadTask.start();
			
			threads.add(threadTask);
		}
		
		int alive = 0;
		do{
			alive = 0;
			
			for(Thread t : threads){
				if (t.isAlive()){
					alive ++;
				}
				
				System.out.println("How many times it found alive threads  : " + alive);
			}
			
		}while (alive > 0);
		
		System.out.println("Main Thread exiting");
	}
}
