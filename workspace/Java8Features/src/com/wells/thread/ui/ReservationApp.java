package com.wells.thread.ui;

import com.wells.model.Flight;
import com.wells.thread.service.ReservationService;

public class ReservationApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Flight f1 = new Flight(20,2);
		Flight f2 = new Flight(20,3);
		Flight f3 = new Flight(30,1);

		ReservationService rs1 = new ReservationService(f1, 10);
		ReservationService rs2 = new ReservationService(f1, 10);
		ReservationService rs3 = new ReservationService(f1, 10);

		/*
		 * try { rs1.reserve(); rs2.reserve(); } catch (InterruptedException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */

		Thread t1 = new Thread(rs1);
		Thread t2 = new Thread(rs2);
		Thread t3 = new Thread(rs3);
		
		t1.start();
		t2.start();
		t3.start();

	}

}
