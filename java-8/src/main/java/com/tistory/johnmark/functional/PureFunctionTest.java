package com.tistory.johnmark.functional;

import java.util.function.Function;

public class PureFunctionTest {
	public static void main(String[] args) {
		int baseNumber = 10;
		PureFunction pureFunction = number -> number + baseNumber;

		System.out.println(pureFunction.addTen(1));
		System.out.println(pureFunction.addTen(1));
		System.out.println(pureFunction.addTen(1));

		System.out.println("-------------------------------------");
		Plus10 plus10 = new Plus10();
		System.out.println(plus10.apply(1));
		System.out.println(plus10.apply(1));
		System.out.println(plus10.apply(1));

		Function<Integer, Integer> plus20 = (number) -> number + 20;

		System.out.println("-------------------------------------");
		System.out.println(plus20.apply(10));
		System.out.println(plus20.apply(10));
		System.out.println("-------------------------------------");

		Function<Integer, Integer> multiply2 = (i) -> i * 2;
		System.out.println(plus10.compose(multiply2).apply(2));
		System.out.println(plus10.andThen(multiply2).apply(2));
	}
}
