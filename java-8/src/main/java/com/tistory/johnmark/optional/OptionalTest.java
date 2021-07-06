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

		Optional<OnlineClass2> spring = springClasses.stream().filter(oc -> oc.getTitle().startsWith("spring"))
			.findFirst();

		if (spring.isPresent()) {
			OnlineClass2 onlineClass2 = spring.get();
			System.out.println("onlineClass2 = " + onlineClass2);
		}

		Optional<OnlineClass2> jpa = springClasses.stream().filter(oc -> oc.getTitle().startsWith("jpa"))
			.findFirst();

		OnlineClass2 onlineClass = jpa.orElseGet(() -> new OnlineClass2(6, "spring new lecture", false));
		System.out.println("onlineClass = " + onlineClass);

		Optional<Integer> integer = spring.map(OnlineClass2::getId);
		if(integer.isPresent()){
			System.out.println("integer = " + integer.get());
		}

		Optional<Optional<Progress>> progress1 = spring.map(OnlineClass2::getProgress);
		System.out.println("progress1 = " + progress1);
		Optional<Progress> progress2 = spring.flatMap(OnlineClass2::getProgress);
		System.out.println("progress2 = " + progress2);
	}
}
