package com.tistory.johnmark.core.singleton;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tistory.johnmark.core.AppConfig;
import com.tistory.johnmark.core.member.MemberRepository;
import com.tistory.johnmark.core.member.MemberServiceImpl;
import com.tistory.johnmark.core.order.OrderServiceImpl;

public class ConfigurationSingletonTest {
	@Test
	void configurationTest() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
			AppConfig.class);

		MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
		OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
		MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);


		MemberRepository memberRepository1 = memberService.getMemberRepository();
		MemberRepository memberRepository2 = orderService.getMemberRepository();

		System.out.println("memberRepository = " + memberRepository);
		System.out.println("memberRepository1 = " + memberRepository1);
		System.out.println("memberRepository2 = " + memberRepository2);

		assertThat(memberRepository1).isSameAs(memberRepository2).isSameAs(memberRepository);
	}
}
