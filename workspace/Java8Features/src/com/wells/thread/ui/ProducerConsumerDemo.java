package com.wells.thread.ui;

import com.wells.thread.service.ConsumerThread;
import com.wells.thread.service.JobExecutor;
import com.wells.thread.service.ProducerThread;

public class ProducerConsumerDemo {

	public static void main(String[] args) {
		
		JobExecutor je = new JobExecutor(5, 10);
		
		ProducerThread pt = new ProducerThread(je);
		ConsumerThread ct = new ConsumerThread(je);
		
		ct.start();
		pt.start();
		

	}

}
