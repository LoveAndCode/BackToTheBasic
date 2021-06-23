package com.tistory.johnmark.abstraction;

public abstract class Phone {
	public String owner;

	public Phone(String owner) {
		this.owner = owner;
	}

	public void isTurnOn() {
		System.out.println(owner + "의 휴대폰 전원을 킵니다.");
	}

	public void isTurnOff() {
		System.out.println(owner + "의 휴대폰 전원을 끕니다.");
	}
}
