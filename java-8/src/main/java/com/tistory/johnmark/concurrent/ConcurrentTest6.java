package com.tistory.johnmark.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentTest6 {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.submit(getRunnable("hello1"));
		executorService.submit(getRunnable("hello2"));
		executorService.submit(getRunnable("hello3"));
		executorService.submit(getRunnable("hello4"));
		executorService.submit(getRunnable("hello5"));

		executorService.shutdown();
	}

	private static Runnable getRunnable(String message) {
		return () -> System.out.println("Message: " + message + " :: " + Thread.currentThread().getName());
	}
}
