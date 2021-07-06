package com.tistory.johnmark.concurrent;

public class ConcurrentTest3 {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(() -> {
			while (true) {
				System.out.println("Thread : " + Thread.currentThread().getName());
				try {
					Thread.sleep(3000L);
				} catch (InterruptedException e) {
					System.out.println("Interrupt..!");
					e.printStackTrace();
					return;
				}
			}
		});

		thread.start();

		System.out.println("Hello : " + Thread.currentThread().getName());
		Thread.sleep(3000L);
		thread.interrupt();
	}
}
