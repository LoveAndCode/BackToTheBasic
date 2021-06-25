package com.tistory.johnmark.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class IterableTest {
	public static void main(String[] args) {
		List<String> name = new ArrayList<>();
		name.add("johnmark");
		name.add("jeanette");
		name.add("jeonghyeon");
		name.add("tomato");

		name.forEach(System.out::println);
		System.out.println("-----------------------------");

		Spliterator<String> spliterator = name.spliterator();
		Spliterator<String> spliterator1 = spliterator.trySplit();
		while (spliterator.tryAdvance(System.out::println));
		System.out.println("-----------------------------");
		while (spliterator1.tryAdvance(System.out::println));
	}
}
