package com.tistory.johnmark.javareflection.reflection.modification;

public class Product {
	public static String A = "A";
	private String B = "B";

	public Product() {
	}

	public Product(String b) {
		B = b;
	}

	public void c() {
		System.out.println("C");
	}

	public int sum(int left, int right) {
		return left + right;
	}

	private void d() {
		System.out.println("D");
	}
}
