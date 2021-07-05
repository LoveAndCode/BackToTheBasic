package com.tistory.johnmark.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalTest {
	public static void main(String[] args) {
		List<OnlineClass2> springClasses = new ArrayList<>();
		springClasses.add(new OnlineClass2(1, "spring boot", true));
		springClasses.add(new OnlineClass2(2, "spring data jpa", true));
		springClasses.add(new OnlineClass2(3, "spring mvc", false));
		springClasses.add(new OnlineClass2(4, "spring core", false));
		springClasses.add(new OnlineClass2(5, "rest api development", false));
		OnlineClass2 spring_boot = new OnlineClass2(1, "spring boot", true);
		Optional<Progress> progress = spring_boot.getProgress();

		if (progress.isPresent()) {
			System.out.println("progress = " + progress.get().getStudyDuration());
		}

	}
}
