package com.wells.mutliThreading;

public class MutlithreadDemo1 {

	public static void main(String[] args) {
		
		Thread t = Thread.currentThread();
		
		System.out.println(t.getName());

		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Got up");
	}

}
