package com.tistory.johnmark.javareflection;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookServiceTest {
	@Autowired
	BookService bookService;

	@Test
	public void di() {
		assertThat(bookService).isNotNull();
		assertThat(bookService.bookRepository).isNotNull();
	}

}