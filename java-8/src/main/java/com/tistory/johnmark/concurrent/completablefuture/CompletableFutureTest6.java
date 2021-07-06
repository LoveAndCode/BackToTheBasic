package com.tistory.johnmark.concurrent.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest6 {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		boolean throwError = true;
		CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
			if (throwError) {
				throw new IllegalStateException();
			}
			System.out.println("Hello " + Thread.currentThread().getName());
			return "Hello";
		}).exceptionally(ex -> {
			System.out.println(ex);
			return "error";
		});
		System.out.println(hello.get());
	}
}
