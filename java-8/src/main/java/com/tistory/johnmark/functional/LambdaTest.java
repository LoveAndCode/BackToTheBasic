package com.tistory.johnmark.functional;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class LambdaTest {

	public static void main(String[] args) {

	}

	private void run() {
		final int baseNumber = 10;

		// Shadowing

		// 로컬 클래스
		class LocalClass {
			void printBaseNumber(){
				int baseNumber = 11;
				System.out.println(baseNumber); // 11
			}
		}

		new LocalClass().printBaseNumber();

		// 익명 클래스
		Consumer<Integer> consumer = new Consumer<>() {
			@Override
			public void accept(Integer baseNumber) {
				System.out.println(baseNumber);
			}
		};

		consumer.accept(11);

		// 람다의 변수 스코프는 해당 람다가 선언된 영역의 스코프와 같다
		IntConsumer printInt = (i) -> {
			System.out.println(i + baseNumber);
		};

		printInt.accept(10);
	}
}
