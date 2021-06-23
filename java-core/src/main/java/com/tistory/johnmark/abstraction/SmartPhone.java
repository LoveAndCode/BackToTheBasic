package com.tistory.johnmark.abstraction;

public class SmartPhone extends Phone {
	public SmartPhone(String owner) {
		super(owner);
	}

	public void internetSearch() {
		System.out.println("인터넷을 겁색합니다.");
	}
}
