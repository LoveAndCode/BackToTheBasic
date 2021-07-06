package com.tistory.johnmark.concurrent;

public class ConcurrentTest1 {
	public static void main(String[] args) {
		// 현재 스레드는 Main 스레드
		System.out.println(Thread.currentThread().getName());

		// 별도의 스레드 생성, 스레드 상속 방법
		MyThread myThread = new MyThread();
		myThread.start();

		// 별도의 스레드 생성, Runnable
		Thread thread = new Thread(() -> {
			System.out.println("Thread[Runnable]: " + Thread.currentThread().getName());
		});
		thread.start();
		System.out.println("Hello!");
	}

	static class MyThread extends Thread {
		@Override
		public void run() {
			System.out.println("Thread[Inheritance]: " + Thread.currentThread().getName());
		}
	}
}
