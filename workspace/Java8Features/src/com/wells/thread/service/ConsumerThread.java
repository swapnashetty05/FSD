package com.wells.thread.service;

public class ConsumerThread extends Thread{

	
	private JobExecutor je;

	public ConsumerThread(JobExecutor je) {
		super();
		this.je = je;
	}

	@Override
	public void run() {
		try {
			je.consumeJob();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	}
	
}
