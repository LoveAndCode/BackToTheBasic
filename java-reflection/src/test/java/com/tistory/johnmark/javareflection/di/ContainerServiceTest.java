package com.tistory.johnmark.javareflection.di;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContainerServiceTest {

	@Test
	@DisplayName("커스텀 DI 어노테이션 테스트")
	public void getObject() {
		BookRepository bookRepository = ContainerService.getObject(BookRepository.class);
		System.out.println("BookRepository HashCode = "+System.identityHashCode(bookRepository));
		assertThat(bookRepository).isNotNull();
	}

	@Test
	@DisplayName("커스텀 DI  어노테이션 테스트 BookService")
	public void getObjetBookService() {
		BookService bookService = ContainerService.getObject(BookService.class);
		assertThat(bookService).isNotNull();
		System.out.println("BookService HashCode = "+System.identityHashCode(bookService));
		assertThat(bookService.bookRepository).isNotNull();
		System.out.println("BookService.bookRepository HashCode = "+System.identityHashCode(bookService.bookRepository));
	}

}