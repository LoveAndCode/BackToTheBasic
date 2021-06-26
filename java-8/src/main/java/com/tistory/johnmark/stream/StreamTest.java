package com.tistory.johnmark.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
	public static void main(String[] args) {
		List<String> name = new ArrayList<>();
		name.add("johnmark");
		name.add("jeanette");
		name.add("jeonghyeon");
		name.add("tomato");

		name.stream().map((s) -> {
			System.out.println(s);
			return s.toUpperCase();
		});

		System.out.println("-----------------------------");

		List<String> stringStream = name.stream()
			.map((s) -> {
				System.out.println(s);
				return s.toUpperCase();
			})
			.collect(Collectors.toList());

		System.out.println("-----------------------------");
		stringStream.forEach(System.out::println);
		System.out.println("-----------------------------");
		name.forEach(System.out::println);
		System.out.println("-----------------------------");

		List<String> collect = name.parallelStream().map((s)-> {
			System.out.println(s + " " + Thread.currentThread().getName());
			return s.toUpperCase();
		}).collect(Collectors.toList());
		collect.forEach(System.out::println);
	}
}
