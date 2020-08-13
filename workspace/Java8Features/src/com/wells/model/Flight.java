package com.wells.model;

public class Flight {
	
	private int maxseat;
	private int lastAllotedSeat;
	private int flightcode;
	
	
	
	
	public Flight(int maxseat, int flightcode) {
		
		this.maxseat = maxseat;
		this.lastAllotedSeat = 0;
		this.flightcode = flightcode;
	}
	public int getMaxseat() {
		return maxseat;
	}
	public void setMaxseat(int maxseat) {
		this.maxseat = maxseat;
	}
	public int getLastAllotedSeat() {
		return lastAllotedSeat;
	}
	public void setLastAllotedSeat(int lastAllotedSeat) {
		this.lastAllotedSeat = lastAllotedSeat;
	}
	public int getFlightcode() {
		return flightcode;
	}
	public void setFlightcode(int flightcode) {
		this.flightcode = flightcode;
	}
	

}
