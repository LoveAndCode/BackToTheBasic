package com.tistory.johnmark.javaproxy;

public class DefaultBookService implements BookService {

	public void ren(Book book) {
		System.out.println("rent: " + book.getTitle());
	}

	@Override
	public void returnBook(Book book) {
		System.out.println("return: " + book.getTitle());
	}
}
