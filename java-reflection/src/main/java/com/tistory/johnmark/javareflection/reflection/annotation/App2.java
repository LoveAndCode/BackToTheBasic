package com.tistory.johnmark.javareflection.reflection.annotation;

import java.util.Arrays;

import com.tistory.johnmark.javareflection.reflection.Book;
import com.tistory.johnmark.javareflection.reflection.MyBook;

public class App2 {
	public static void main(String[] args) {
		Class<Book> bookClass = Book.class;
		Arrays.stream(bookClass.getAnnotations()).forEach(System.out::println);

		System.out.println("----------------------------------------------");
		Class<MyBook> myBookClass = MyBook.class;
		Arrays.stream(myBookClass.getAnnotations()).forEach(System.out::println);
		System.out.println("----------------------------------------------");
		Arrays.stream(myBookClass.getDeclaredAnnotations()).forEach(System.out::println);
		Arrays.stream(myBookClass.getDeclaredAnnotations()).forEach(annotation -> {
			if (annotation instanceof AnotherAnnotation) {
				AnotherAnnotation myAnnotation = (AnotherAnnotation)annotation;
				System.out.println("myAnnotation = " + myAnnotation);
				System.out.println("value = " + myAnnotation.value());
			}
		});

	}
}
