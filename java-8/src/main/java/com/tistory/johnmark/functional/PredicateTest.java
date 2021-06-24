package com.tistory.johnmark.functional;

import java.util.function.Predicate;

public class PredicateTest {
	public static void main(String[] args) {
		Predicate<String> startWithJohn = (name) -> name.startsWith("John");

		System.out.println("JohnMark => " + startWithJohn.test("JohnMark"));
		System.out.println("Mark => " + startWithJohn.test("Mark"));
		System.out.println("MarkJohn => " + startWithJohn.test("MarkJohn"));
	}
}
