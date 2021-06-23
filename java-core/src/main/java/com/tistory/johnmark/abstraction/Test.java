package com.tistory.johnmark.abstraction;

public class Test {
	public static void main(String[] args) {
		SmartPhone smartPhone = new SmartPhone("JohnMark");

		smartPhone.isTurnOn();
		smartPhone.internetSearch();
		smartPhone.isTurnOff();
	}
}
