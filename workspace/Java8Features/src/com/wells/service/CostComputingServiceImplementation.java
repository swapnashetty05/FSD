package com.wells.service;

public class CostComputingServiceImplementation implements CostComputingService {

	@Override
	public double getSellingPrice(double costPrice) {
		
		return costPrice + (costPrice *0.02);
	}

}
