package com.tistory.johnmark.functional;

public class Greeting {
	private String name;

	public Greeting() {
	}

	public Greeting(String name) {
		this.name = name;
	}

	public static String hi(String name) {
		return "hi " + name;
	}

	public String hello(String name) {
		return "hello " + name;
	}

	public String getMyName() {
		return this.name;
	}
}
