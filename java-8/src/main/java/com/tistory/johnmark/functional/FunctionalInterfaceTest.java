package com.tistory.johnmark.functional;

import java.util.Arrays;
import java.util.List;

public class FunctionalInterfaceTest {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("JohnMark", "JeongHyeon", "Bob", "Mark", "Richard", "Narisa");
		List<Integer> scores = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 95, 100);

		for (String name : names) {
			// 함수형 인터페이스를 통해 함수자체를 값으로 넘김
			if (isValid(() -> name.startsWith("J"))) {
				System.out.printf("Matched Name: [%s]\n", name);
			}
		}

		System.out.println("------------------------------------------");

		for (int score : scores) {
			// 함수형 인터페이스를 통해 함수자체를 값으로 넘김
			if (isValid(() -> score > 50)) {
				System.out.printf("Matched Score: [%d]\n", score);
			}
		}
		System.out.println("============================================");
		SimpleValidator validator = new SimpleValidator();
		SimpleValidator validator2 = new SimpleValidator();

		Validator.printClassName();
		System.out.println(validator.getClassName());
		System.out.println(validator2.getClassName());
		System.out.println(validator2.getNumber());
	}

	public static boolean isValid(Validator validator) {
		return validator.match();
	}
}
