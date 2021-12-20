package com.tistory.johnmark.deadlock;

public class DeadLock {
	public static void main(String[] args) {
		final Object lock1 = new Object();
		final Object lock2 = new Object();

		Thread thread1 = new Thread(() -> {
			synchronized (lock1) {
				System.out.println("Thread 1 holds lock 1");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}
				synchronized (lock2) {
					System.out.println("Thread 1 holds lock 2");
				}
			}
		});

		Thread thread2 = new Thread(() -> {
			synchronized (lock2) {
				System.out.println("Thread 2 hold lock 2");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
				synchronized (lock1) {
					System.out.println("Thread 2 holds lock 1");
				}
			}
		});

		thread1.start();
		thread2.start();
	}
}
