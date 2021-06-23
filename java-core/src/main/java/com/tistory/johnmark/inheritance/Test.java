package com.tistory.johnmark.inheritance;

public class Test {
	public static void main(String[] args) {
		Child child = new Child();
		child.method3();
		Parent parent = child;
		parent.method1();
		parent.method2();

		System.out.println("==========================================");

		Driver driver = new Driver();
		Vehicle vehicle = new Vehicle();
		driver.drive(vehicle);
		Bus bus = new Bus();
		driver.drive(bus);
	}
}
