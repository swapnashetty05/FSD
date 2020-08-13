package com.wells.mutliThreading;

public class RandomSeriesGenDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		randomSeries g1 = new randomSeries(10);
		randomSeries g2 = new randomSeries(13);
	

	Thread t1 = new Thread(g1,"t1");
	Thread t2 = new Thread(g2,"t2");
	
//	t1.setPriority(1);
//	t2.setPriority(10);
	
	t1.start();
	t2.start();
	
	try {
		t1.join();
		t2.join();
	} catch (InterruptedException e) {
		System.out.println("Exception ");
		e.printStackTrace();
	}
	
	System.out.println("Program terminated");
}
}

