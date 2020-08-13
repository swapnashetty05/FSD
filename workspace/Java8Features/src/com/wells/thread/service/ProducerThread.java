package com.wells.thread.service;

public class ProducerThread extends Thread{

	
	private JobExecutor je;

	public ProducerThread(JobExecutor je) {
		super();
		this.je = je;
	}

	@Override
	public void run() {
		try {
			je.produceJob();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
