package com.tistory.johnmark.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentTest5 {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.execute(() -> {
			System.out.println("Thread : " + Thread.currentThread().getName());
		});

		executorService.shutdown();
	}
}
