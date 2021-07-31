package com.tistory.johnmark.javaproxy;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookRepositoryTest {
	@Autowired
	BookRepository bookRepository;

	@Test
	public void di() {
		assertThat(bookRepository).isNotNull();

		Book book = new Book();
		book.setTitle("spring");
		bookRepository.save(book);
		bookRepository.findAll().stream().forEach(System.out::println);
	}
}