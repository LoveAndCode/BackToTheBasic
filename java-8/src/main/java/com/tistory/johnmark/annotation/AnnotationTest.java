package com.tistory.johnmark.annotation;

import java.util.Arrays;
import java.util.List;

public class AnnotationTest {
	public static void main(@Chicken String[] args) throws @Chicken RuntimeException{
		List<@Chicken String> names = Arrays.asList("JohnMark");
	}

	static class FeelsLikeChicken<@Chicken T> {
		public static <@Chicken C> void print(@Chicken C c) {

		}
	}
}
