package com.tistory.johnmark.functional;

import java.util.function.Consumer;

public class ConsumerTest {
	public static void main(String[] args) {
		Consumer<Integer> consumer = (number) -> System.out.println("number = " + number);

		consumer.accept(10);
	}
}
