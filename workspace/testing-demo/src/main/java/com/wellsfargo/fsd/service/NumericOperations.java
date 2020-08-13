package com.wellsfargo.fsd.service;

import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.fsd.exception.MyException;

public class NumericOperations {

	
	public boolean isOdd(int num) {
		return num%2 ==1 || num%2==-1;
	}
	
	public int quot(int n1, int n2) throws MyException {
		
		if(n2==0) {
			throw new MyException("Zero cannot be a divisor");
		}
		return n1/ n2;
	}
	
	public List<Integer> getFactors(int number){
		List<Integer> factors = new ArrayList<>();
		
		factors.add(1);
		for(int i=2;i<=number/2;i++) {
			if(number%i==0) {
				factors.add(i);
			}
		}
		factors.add(number);	
		
		return factors;
	}
}
