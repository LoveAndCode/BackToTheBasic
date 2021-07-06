package com.tistory.johnmark.concurrent.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest1 {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		CompletableFuture<String> future = new CompletableFuture<>();
		future.complete("JohnMark");

		System.out.println(future.get());
	}
}
