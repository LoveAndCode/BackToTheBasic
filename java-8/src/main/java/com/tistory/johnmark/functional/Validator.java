package com.tistory.johnmark.functional;

@FunctionalInterface
public interface Validator {
	static void printClassName() {
		System.out.println("Validator");
	}

	default String getClassName() {
		return "Validator";
	}

	default int getNumber() {
		return 1;
	}

	boolean match();
}
