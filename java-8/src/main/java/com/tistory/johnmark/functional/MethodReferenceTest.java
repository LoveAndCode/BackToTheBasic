package com.tistory.johnmark.functional;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodReferenceTest {
	public static void main(String[] args) {
		UnaryOperator<String> hi = (s) -> "hi " + s;
		UnaryOperator<String> hi2 = Greeting::hi;

		System.out.println(hi2.apply("JohnMark"));

		Greeting greeting = new Greeting();

		UnaryOperator<String> hi3 = greeting::hello;

		System.out.println(hi3.apply("JohnMark"));

		Supplier<Greeting> newGreeting = Greeting::new;
		Greeting greeting1 = newGreeting.get();

		Function<String, Greeting> greetingFunction = Greeting::new;

		System.out.println(greetingFunction.apply("JohnMark").getMyName());

		String[] names = {"JohnMark", "JeongHyeon", "Jeanette"};

		Arrays.sort(names, String::compareToIgnoreCase);

		System.out.println(Arrays.toString(names));
	}
}
