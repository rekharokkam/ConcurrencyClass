package com.learning.basicjava.basic;

import java.awt.Frame;
import java.util.Set;

public class MultiThreadEx
{
	private void demo (){
		//Create and Configure a Top level Window
		Frame window = new Frame("Hello World");
		window.setSize(600, 200);
		
		listThreads ("Before the frame is shown");
		
		window.setVisible(true);
		
		listThreads ("After the window is shown");
	}
	
	private void listThreads(String msg)
	{
System.out.println(msg);
		Set<Thread> activeThreads = Thread.getAllStackTraces().keySet();//Runtime Reflection is costly. 
		
		for (Thread thread : activeThreads){
			System.out.printf("\n\t Name : %s :: Id : %d :: user/Daemon : %s", thread.getName(), thread.getId(), (thread.isDaemon() ? "Daemon" : "User"));
		}
	}

	public static void main(String[] args)
	{
		System.out.println("Main Thread started .........");
		new MultiThreadEx().demo();
		System.out.println("\nMain Thread About to Exit.........");
	}
}
