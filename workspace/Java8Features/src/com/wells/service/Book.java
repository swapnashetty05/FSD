package com.wells.service;

import java.time.LocalDate;

public class Book {

	
	private Long bookCode;
	private String title;
	private Double price;
	private LocalDate publishDate;
	
	public Book() {}
	
	
	@Override
	public String toString() {
		return "Book [bookCode=" + bookCode + ", title=" + title + ", price=" + price + ", publishDate=" + publishDate
				+ "]";
	}


	public Book(Long bookCode, String title, Double price, LocalDate publishDate) {
		super();
		this.bookCode = bookCode;
		this.title = title;
		this.price = price;
		this.publishDate = publishDate;
	}


	public Long getBookCode() {
		return bookCode;
	}


	public void setBookCode(Long bookCode) {
		this.bookCode = bookCode;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public LocalDate getPublishDate() {
		return publishDate;
	}


	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}
	
	
}
