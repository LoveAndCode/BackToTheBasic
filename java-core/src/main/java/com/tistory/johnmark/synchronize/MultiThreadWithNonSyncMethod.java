package com.tistory.johnmark.synchronize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class MultiThreadWithNonSyncMethod {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(3);
		SynchronizedMethod summation = new SynchronizedMethod();

		IntStream.range(0, 100).forEach(count -> service.submit(summation::calculate));
		service.awaitTermination(1000, TimeUnit.MILLISECONDS);
		System.out.printf("Is Same 1000 == %d  is %s", summation.getSum(), summation.getSum() == 1000);
	}
}
