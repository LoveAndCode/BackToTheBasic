package synchronize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.tistory.johnmark.synchronize.SynchronizedMethod;

public class MultiThreadNotSynchronizedTest {

	@Test
	@DisplayName("Synchronized 되지 않은 상태에서 멀티스레드 테스트")
	public void multiThreadTestAsNotSync() throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(3);
		SynchronizedMethod summation = new SynchronizedMethod();

		IntStream.range(0, 100).forEach(count -> service.submit(summation::calculate));
		service.awaitTermination(1000, TimeUnit.MILLISECONDS);
		Assertions.assertEquals(1000, summation.getSum());
	}
}
