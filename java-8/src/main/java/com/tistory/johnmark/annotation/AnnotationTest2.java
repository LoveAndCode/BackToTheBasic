package com.tistory.johnmark.annotation;

@Chicken2("마늘 간장")
@Chicken2("후라이드")
@Chicken2("양념")
public class AnnotationTest2 {
	public static void main(String[] args) throws RuntimeException {
		Chicken2[] chickens = AnnotationTest2.class.getAnnotationsByType(Chicken2.class);
		for (Chicken2 chicken2 : chickens) {
			System.out.println("chicken2 = " + chicken2);
		}

		System.out.println("-----------------------------------------------------");

		// Get Annotation Value Via Container Annotation
		ChickenContainer chickenContainer = AnnotationTest2.class.getAnnotation(ChickenContainer.class);
		for (Chicken2 chicken2 : chickenContainer.value()) {
			System.out.println("chicken2 = " + chicken2);
		}

	}
}
