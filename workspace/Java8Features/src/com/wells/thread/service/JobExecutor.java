package com.wells.thread.service;

import java.util.LinkedList;
import java.util.List;

public class JobExecutor {

	
	private List<Integer> jobs;
	private int jobMaxCapacity;
	private int jobCount;
	public JobExecutor(int jobMaxCapacity, int jobCount) {
		super();
		this.jobMaxCapacity = jobMaxCapacity;
		this.jobCount = jobCount;
		this.jobs = new LinkedList<>();
	}
	
	
	private boolean isFull() {
		return jobs.size()==jobMaxCapacity;
	}
	
	private boolean isEmpty() {
		return jobs.isEmpty();
	}
	
	public void produceJob() throws InterruptedException {
		
		for(int i =0;i<jobCount;i++) {
		synchronized (this) {
			while(isFull()) {
				this.wait();
			}
			System.out.println("Produced job#" +i);
			jobs.add(i);
			
			notify();
			Thread.sleep(1000);
		}
	}}
	
	
public void consumeJob() throws InterruptedException {
		
		for(int i =0;i<jobCount;i++) {
		synchronized (this) {
			while(isFull()) {
				this.wait();
			}
			int jobId = jobs.remove(0);
			System.out.println("consumed job#" +jobId);
			jobs.add(i);
			
			notify();
			Thread.sleep(1000);
		}
	}}
	
}
