package com.tistory.johnmark.interfaces;

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

		name.forEach(System.out::println);

		String test = name.stream().filter(s -> s.startsWith("t")).collect(Collectors.joining());
		System.out.println(test);

	}
}
