package com.wells.thread.service;

import java.util.ArrayList;
import java.util.List;

import com.wells.model.Flight;

public class ReservationService implements Runnable {

	
	private Flight flight;
	private int requiredSeatCount;
	private List<Integer> seatsReserved;
	
	private boolean isFlightFull() {
		return flight.getLastAllotedSeat() == flight.getMaxseat();
	}
	
	
	private int availableSeats() {
		return flight.getMaxseat() -flight.getLastAllotedSeat();
	}
	public ReservationService(Flight flight, int requiredSeatCount) {
		
		this.flight = flight;
		this.requiredSeatCount = requiredSeatCount;
		this.seatsReserved = new ArrayList<>();
	}

	public void reserve() throws InterruptedException {

		Thread t = Thread.currentThread();
		String name = t.getName();
		
		if(isFlightFull()) {
			System.out.println("Sorry flight is full");
		} else if(availableSeats()< requiredSeatCount){
			System.out.println(name +">> sorry not enough seat");
		} else
		{
			synchronized (this.flight) {
				
			while(requiredSeatCount>0) {
			if(availableSeats() >=requiredSeatCount) {
				int seatToBeReserved = flight.getLastAllotedSeat()+1;
				seatsReserved.add(seatToBeReserved);
				flight.setLastAllotedSeat(seatToBeReserved);
				requiredSeatCount--;
				System.out.println(name +">>Reserved seat#" +seatToBeReserved);
				Thread.sleep(1000);
			}
			else {
				break;
			}
		}
			
		}}
		System.out.println(name + ">> "+flight.getFlightcode() + seatsReserved);
		
	}
	

	@Override
	public void run() {
		try {
			reserve();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		

}
