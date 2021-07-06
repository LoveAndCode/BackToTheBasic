package com.tistory.johnmark.concurrent;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ConcurrentTest7 {
	public static void main(String[] args) {
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		executorService.scheduleAtFixedRate(getRunnable("Hello"), 1, 2, TimeUnit.SECONDS);
	}

	private static Runnable getRunnable(String message) {
		return () -> System.out.println(
			LocalDateTime.now() + " Message: " + message + " :: " + Thread.currentThread().getName());
	}
}
