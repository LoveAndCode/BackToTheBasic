package com.tistory.johnmark.javaproxy;

import org.junit.jupiter.api.Test;

public class BookServiceTest {
	BookService bookService = new BookServiceProxy(new DefaultBookService());

	@Test
	public void di() {
		Book book = new Book();
		book.setTitle("spring");
		bookService.ren(book);
	}
}