package com.tistory.johnmark.javaproxy;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookRepositoryTest {
	@Test
	public void di() {
		MethodInterceptor handler = new MethodInterceptor() {
			BookService bookService = new BookService();

			@Override
			public Object intercept(
				Object o, Method method, Object[] objects, MethodProxy methodProxy
			) throws Throwable {
				if (method.getName().equals("rent")) {
					System.out.println("AACC");
					Object invoke = method.invoke(bookService, objects);
					System.out.println("DDEE");
					return invoke;
				}
				return method.invoke(bookService, objects);
			}
		};
		BookService bookService = (BookService)Enhancer.create(BookService.class, handler);
		Book book = new Book();
		book.setTitle("spring");

		bookService.rent(book);
		bookService.returnBook(book);
	}
}