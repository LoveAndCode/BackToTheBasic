package com.tistory.johnmark.concurrent.callable;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest2 {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		System.out.println(LocalDateTime.now());
		Callable<String> hello = () -> {
			Thread.sleep(2000L);
			return "Hello";
		};

		Callable<String> java = () -> {
			Thread.sleep(3000L);
			return "java";
		};

		Callable<String> mark = () -> {
			Thread.sleep(1000L);
			return "mark";
		};

		// 모든 일이 끝날때까지 기다렸다가 result를 가져옴
		List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, mark));
		for (Future f : futures) {
			System.out.println(f.get());
		}
		executorService.shutdown();
		System.out.println(LocalDateTime.now());
	}
}
