package com.tistory.johnmark.concurrent.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest1 {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		Callable<String> hello = () -> {
			Thread.sleep(3000L);
			return "Hello";
		};

		Future<String> submit = executorService.submit(hello);


		System.out.println(submit.isDone());

		System.out.println("Started!");

		// String s = submit.get();//블록킹 콜

		submit.cancel(false);

		System.out.println(submit.isDone());

		System.out.println("End.!");

		executorService.shutdown();
	}
}
