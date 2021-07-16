package com.tistory.johnmark.array;

	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.List;

public class ArrayTest2 {
	public static void main(String[] args) {
		List<Integer> score = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> source2 = new ArrayList<>();
		source2.add(1);
		source2.add(2);

		System.out.printf("score: %s , score2: %s \n", score, Arrays.asList(1, 2));

		System.out.println("--------------------------------------------------------");
		score.removeAll(source2);
		System.out.println("score - score2 = " + score);
	}
}
