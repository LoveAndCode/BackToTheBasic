package com.tistory.johnmark.functional;

import java.util.function.UnaryOperator;

public class UnaryOperatorTest {
	public static void main(String[] args) {
		// if input and return type same, then u can using UnaryOperator
		UnaryOperator<Integer> unaryOperator = (number) -> number + 1;

		System.out.println("unaryOperator = " + unaryOperator.apply(19));
	}
}
