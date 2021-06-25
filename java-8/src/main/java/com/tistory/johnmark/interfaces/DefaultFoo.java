package com.tistory.johnmark.interfaces;

public class DefaultFoo implements FooInterface {
	private String name;

	public DefaultFoo(String name) {
		this.name = name;
	}

	@Override
	public void printName() {
		System.out.println(name);
	}

	@Override
	public String getName() {
		return name;
	}
}
