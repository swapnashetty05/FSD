package com.wells.ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateCheck {

	public static void main(String[] args) {
		
		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		System.out.println(today.format(dtf));
		
		LocalDate ind = LocalDate.of(1947, Month.AUGUST, 15);
		System.out.println(ind.format(dtf));
		
		Period p = Period.between(ind, today);
		System.out.println(p);
		
		System.out.println(p.getYears());
		System.out.println(p.toTotalMonths());
		
		String dob = "11-Jun-1985";
		LocalDate dobSt = LocalDate.parse(dob,dtf);
		System.out.println(Period.between(dobSt, today));
		
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt);
		
		dt.atZone(ZoneId.of("America/Los_Angeles"));

	}

}
