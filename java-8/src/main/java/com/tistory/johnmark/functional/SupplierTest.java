package com.tistory.johnmark.functional;

import java.util.function.Supplier;

public class SupplierTest {
	public static void main(String[] args) {
		Supplier<Integer> get10 = () -> 10;
		System.out.println("get10 = " + get10.get());
	}
}
