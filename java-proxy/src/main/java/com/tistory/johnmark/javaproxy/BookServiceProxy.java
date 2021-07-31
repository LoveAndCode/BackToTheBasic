package com.tistory.johnmark.javaproxy;

public class BookServiceProxy implements BookService {

	BookService bookService;

	public BookServiceProxy(BookService bookService) {
		this.bookService = bookService;
	}

	@Override
	public void rent(Book book) {
		System.out.println("aaaaa");
		bookService.rent(book);
		System.out.println("bbbbb");
	}

	@Override
	public void returnBook(Book book) {
		System.out.println("aaaaaaaa");
		bookService.returnBook(book);
		System.out.println("bbbbb");
	}
}
