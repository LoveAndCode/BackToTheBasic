package com.tistory.johnmark.concurrent;

public class ConcurrentTest4 {
	public static void main(String[] args) {
		Thread thread = new Thread(() -> {
			System.out.println("Tread: " + Thread.currentThread().getName());
			try {
				Thread.sleep(3000L);
			} catch (InterruptedException e) {
				throw new IllegalStateException();
			}
		});

		thread.start();

		System.out.println("Hello : " + Thread.currentThread().getName());
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(thread + " is finished");
	}
}
