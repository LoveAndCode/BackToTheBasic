package com.tistory.johnmark.concurrent.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CompletableFutureTest4 {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
			System.out.println("Hello " + Thread.currentThread().getName());
			return "Hello";
		});

		CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
			System.out.println("World " + Thread.currentThread().getName());
			return "World";
		});

		List<CompletableFuture<String>> futures = Arrays.asList(hello, world);
		CompletableFuture[] futureArray = futures.toArray(new CompletableFuture[futures.size()]);

		CompletableFuture<List<String>> listCompletableFuture = CompletableFuture.allOf(futureArray)
			.thenApply(v -> futures.stream()
				.map(CompletableFuture::join)
				.collect(Collectors.toList())
			);

		listCompletableFuture.get().forEach(System.out::println);
	}
}
