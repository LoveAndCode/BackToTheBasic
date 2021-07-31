package com.tistory.johnmark.javaproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.jupiter.api.Test;

public class BookServiceTest {
	// BookService bookService = (BookService)Proxy.newProxyInstance(BookService.class.getClassLoader(),
	// 	new Class[] {BookService.class}, new InvocationHandler() {
	// 		BookService bookService = new DefaultBookService();
	//
	// 		@Override
	// 		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	// 			if (method.getName().equals("rent")) {
	// 				System.out.println("AAAAAAAAAA");
	// 				Object invoke = method.invoke(bookService, args);
	// 				System.out.println("BBBBBBBBBB");
	// 				return invoke;
	// 			}
	// 			return method.invoke(bookService, args);
	// 		}
	// 	}
	// );
	BookService bookService = (BookService)Proxy.newProxyInstance(
		BookService.class.getClassLoader(),
		new Class[] {IBookService.class}, new InvocationHandler() {
			BookService bookService = new BookService();

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if (method.getName().equals("rent")) {
					System.out.println("AAAAAAAAAA");
					Object invoke = method.invoke(bookService, args);
					System.out.println("BBBBBBBBBB");
					return invoke;
				}
				return method.invoke(bookService, args);
			}
		}
	);
	@Test
	public void di() {
		Book book = new Book();
		book.setTitle("spring");
		bookService.rent(book);

		bookService.returnBook(book);
	}
}