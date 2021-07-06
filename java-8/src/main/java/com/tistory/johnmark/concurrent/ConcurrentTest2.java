package com.tistory.johnmark.concurrent;

public class ConcurrentTest2 {
	public static void main(String[] args) {
		Thread thread = new Thread(() -> {
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread[Runnable]: " + Thread.currentThread().getName());
		});

		thread.start();

		System.out.println("Hello: " + Thread.currentThread().getName());
	}
}
