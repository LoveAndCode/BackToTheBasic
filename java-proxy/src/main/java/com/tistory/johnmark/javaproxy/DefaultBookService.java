package com.tistory.johnmark.javaproxy;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

public class DefaultBookService implements BookService{

	public void ren(Book book) {
		System.out.println("rent: " + book.getTitle());
	}
}
