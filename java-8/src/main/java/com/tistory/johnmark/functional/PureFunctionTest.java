package com.tistory.johnmark.functional;

public class PureFunctionTest {
	public static void main(String[] args) {
		int baseNumber = 10;
		PureFunction pureFunction = number -> number + baseNumber;

		System.out.println(pureFunction.addTen(1));
		System.out.println(pureFunction.addTen(1));
		System.out.println(pureFunction.addTen(1));
	}
}
