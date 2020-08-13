package com.wells.ui;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.wells.service.Book;

public class BookSortDemo {

	public static void main(String[] args) {

		List<Book> books = Arrays
				.asList(new Book[] { new Book(90L, "swap", 8990.00, LocalDate.of(2020, Month.AUGUST, 5)),
						new Book(90L, "pk", 8990.00, LocalDate.of(2020, Month.AUGUST, 1)),
						new Book(90L, "nixu", 8990.00, LocalDate.of(2020, Month.AUGUST, 15)),
						new Book(90L, "sps", 8990.00, LocalDate.of(2020, Month.AUGUST, 25)),
						new Book(90L, "rss", 8990.00, LocalDate.of(2020, Month.AUGUST, 9))

				});

		for (Book b : books) {
			System.out.println(b);
		}

		System.out.println("---------------------------");

		Collections.sort(books, (b1, b2) -> b1.getBookCode().compareTo(b2.getBookCode()));
		for (Book b : books) {
			System.out.println(b);
		}

		System.out.println("-------------reverse--------------");
		
		Collections.sort(books, Collections.reverseOrder((b1, b2) -> b1.getTitle().compareTo(b2.getTitle())));
		for (Book b : books) {
			System.out.println(b);
		}
		
//		Collections.sort(books, Collections.frequency((b1, b2) -> , o)((b1, b2) -> b1.getTitle().compareTo(b2.getTitle())));
//		for (Book b : books) {
//			System.out.println(b);
//		}
	}

}
