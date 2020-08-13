package com.wells.mutliThreading;

import java.util.Random;

public class randomSeries implements Runnable{

	private Random random;
	private int count;
	public randomSeries( int count) {
		
		this.random =new  Random();
		this.count = count;
	}
	
	public void generateSeries() {
		String tName = Thread.currentThread().getName();
		
		
		for(int counter = 0;counter<=count;counter++) {
			System.out.println(tName+">>"+random.nextInt(100));
			
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		generateSeries();
		
	}
	
	
//	public static void main(String[] args) {
//		
//
//	}

}
