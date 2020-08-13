package com.wells.ui;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.wells.service.Book;

public class StreamDemo {

	public static void main(String[] args) {
		List<Book> books = Arrays
				.asList(new Book[] { new Book(90L, "swap", 8990.00, LocalDate.of(2020, Month.AUGUST, 5)),
						new Book(90L, "swap21", 990.00, LocalDate.of(2020, Month.AUGUST, 1)),
						new Book(90L, "swap31", 890.00, LocalDate.of(2020, Month.AUGUST, 15)),
						new Book(90L, "swap22", 899.00, LocalDate.of(2020, Month.AUGUST, 25)),
						new Book(90L, "swap211", 8990.00, LocalDate.of(2020, Month.AUGUST, 9))

				});
		
		books.stream().forEach(System.out::println);
		books.stream().forEach((b)-> {b.setPrice(b.getPrice()+100);});
		System.out.println("----------------------------------------");
		books.stream().forEach(System.out::println);

		
		
		Optional<Book> results = books.stream().reduce((b1,b2)-> b1.getPrice()>b2.getPrice()?b1:b2);
		if(results.isPresent()) {
			System.out.println(results.get());
		}
		
		System.out.println("----------------------------------------");
		books.stream().forEach(System.out::println);

		
		
		Optional<Book> result = books.stream().reduce((b1,b2)-> b1.getPublishDate().isAfter(b2.getPublishDate())?b1:b2);
		if(result.isPresent()) {
			System.out.println(result.get());
		}
		
		System.out.println("-----------------filter-----------------------");
		books.stream().filter((b)-> b.getPrice()<9000).forEach(System.out::println);
		
		
		System.out.println("-----------------filter-collector-----------------------");
		List<Book> booksres = books.stream().filter((b)-> b.getPrice()<9000).collect(Collectors.toList());
		System.out.println(booksres);
		
		
		System.out.println("-----------------map-----------------------");
		books.stream().map((b)-> b.getTitle()).forEach(System.out::println);
		
		System.out.println("-----------------map-----------------------");
		Stream.of(1,3,2,3,2,5,6,7).map((b)-> b*b).forEach(System.out::println);
		
		Stream.of(99999).map((b)-> b-100).forEach(System.out::println);
		
	}
	
	

}
