package com.tistory.johnmark.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {
	@Test
	void statefulServiceSingleton() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
		StatefulService statefulService1 = ac.getBean(StatefulService.class);
		StatefulService statefulService2 = ac.getBean(StatefulService.class);

		// ThreadA: A 사용자 1000원 주문
		statefulService1.order("userA", 1000);
		// ThreadB: B 사용자 2000원 주문
		statefulService2.order("userB", 2000);

		// ThreadA: 사용자 A 주문 금액 조회
		int price = statefulService1.getPrice();
		System.out.println("price = " + price);
	}

	static class TestConfig {
		@Bean
		public StatefulService statefulService() {
			return new StatefulService();
		}
	}
}
