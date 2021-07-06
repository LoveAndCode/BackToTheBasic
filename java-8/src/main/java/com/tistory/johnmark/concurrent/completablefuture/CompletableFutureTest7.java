package com.tistory.johnmark.concurrent.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest7 {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		boolean throwError = true;
		CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
			if (throwError) {
				throw new IllegalStateException();
			}
			System.out.println("Hello " + Thread.currentThread().getName());
			return "Hello";
		}).handle((result, ex) -> {
			if (ex != null) {
				System.out.println(ex);
				return "ERROR";
			}
			return result;
		});
		System.out.println(hello.get());
	}
}
