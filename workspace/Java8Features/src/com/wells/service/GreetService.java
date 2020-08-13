package com.wells.service;

@FunctionalInterface
public interface GreetService {

	//if we are not specifing modifier it is default public abstract
	public abstract String greet(String userName);
	
	//public abstract String yo(String h);
}
