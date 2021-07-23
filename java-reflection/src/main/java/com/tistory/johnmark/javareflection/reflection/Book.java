package com.tistory.johnmark.javareflection.reflection;

import com.tistory.johnmark.javareflection.reflection.annotation.MyAnnotation;

@MyAnnotation("JoengHyeon")
public class Book {
	private static final String C = "Book";
	private static String B = "Book";
	public String d = "d";
	protected String e = "e";
	private String a = "a";

	public Book() {
	}


	public Book(String a) {
		this.a = a;
	}

	public Book(String a, String d, String e) {
		this.a = a;
		this.d = d;
		this.e = e;
	}

	private void f() {
		System.out.println("F");
	}

	public void g() {
		System.out.println("G");
	}

	public int h() {
		return 100;
	}

}
