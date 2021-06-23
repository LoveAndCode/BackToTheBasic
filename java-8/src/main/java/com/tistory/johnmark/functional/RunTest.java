package com.tistory.johnmark.functional;

public class RunTest {
	public static void main(String[] args) {
		// 익명 내부 클래스 anonymous inner class
		RunSomeThing runSomeThing = new RunSomeThing() {
			@Override
			public void doIt() {
				System.out.println("This is Anonymous Inner Class");
			}
		};
		System.out.println("--------------------------------------------");
		runSomeThing.doIt();

		// java 8 , functional interface
		RunSomeThing runSomeThing1 = () -> System.out.println("This is Lambda!");
		RunSomeThing runSomeThing2 = () -> {
			System.out.println("This is FunctionalInterface");
			System.out.println("This is Lambda!");
		};
		System.out.println("--------------------------------------------");
		runSomeThing1.doIt();
		System.out.println("--------------------------------------------");
		runSomeThing2.doIt();
	}
}
