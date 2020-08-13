package com.wells.ui;

import com.wells.service.CostComputingService;
import com.wells.service.CostComputingServiceImplementation;
import com.wells.service.costComputingServiceGreedyImpl;

public class InterfaceDemo {

	public static void main(String[] args) {
		CostComputingService ccs1 = new CostComputingServiceImplementation();
		CostComputingService ccs2 = new costComputingServiceGreedyImpl();
		
		System.out.println(ccs1.getSellingPrice(100));
		System.out.println(ccs2.getSellingPrice(100));
		
		System.out.println(ccs1.getTax(100));
		System.out.println(ccs2.getTax(100));
		
		

	}

}
