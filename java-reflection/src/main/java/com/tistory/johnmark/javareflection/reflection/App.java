package com.tistory.johnmark.javareflection.reflection;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class App {
	public static void main(String[] args) throws ClassNotFoundException {
		// Get Class From Type
		Class<Book> bookClassFromType = Book.class;
		System.out.println("Type = " + bookClassFromType.getSimpleName());

		// Get Class From Instance
		Book book = new Book();
		Class<? extends Book> bookClassFromInstance = book.getClass();
		System.out.println("Instance = " + bookClassFromInstance.getSimpleName());

		// Get Class From Full qualified class name
		Class<?> bookClassFromFQCN = Class.forName("com.tistory.johnmark.javareflection.reflection.Book");
		System.out.println("FQCN = " + bookClassFromFQCN.getSimpleName());

		System.out.println("------------------------------------------");

		// Get Field Only Declared Public
		Arrays.stream(bookClassFromFQCN.getFields()).forEach(System.out::println);

		System.out.println("------------------------------------------");

		// Get All Filed
		Arrays.stream(bookClassFromFQCN.getDeclaredFields()).forEach(System.out::println);

		System.out.println("------------------------------------------");

		// Get filed value from instance
		Arrays.stream(bookClassFromFQCN.getDeclaredFields()).forEach(f -> {
			try {
				f.setAccessible(true);
				System.out.printf("%s = %s \n", f, f.get(book));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		});

		System.out.println("------------------------------------------");
		Arrays.stream(bookClassFromType.getDeclaredMethods()).forEach(System.out::println);

		System.out.println("------------------------------------------");
		// Get Super Class Information
		Class<?> superclass = MyBook.class.getSuperclass();
		System.out.println(superclass);


		System.out.println("------------------------------------------");
		// Get Interfaces
		Class<?>[] interfaces = MyBook.class.getInterfaces();
		Arrays.stream(interfaces).forEach(System.out::println);


		System.out.println("------------------------------------------");
		Arrays.stream(Book.class.getDeclaredFields()).forEach( f -> {
			int modifier = f.getModifiers();
			System.out.println(f);
			System.out.println(Modifier.isPrivate(modifier));
			System.out.println(Modifier.isStatic(modifier));
			System.out.println(Modifier.isFinal(modifier));
			System.out.println(Modifier.isPrivate(modifier));
			System.out.println(Modifier.isProtected(modifier));
		});

	}
}
