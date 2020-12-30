package com.tistory.johnmark.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tistory.johnmark.core.discount.DiscountPolicy;
import com.tistory.johnmark.core.discount.RateDiscountPolicy;
import com.tistory.johnmark.core.member.MemberService;
import com.tistory.johnmark.core.member.MemberServiceImpl;
import com.tistory.johnmark.core.member.MemoryMemberRepository;
import com.tistory.johnmark.core.order.OrderService;
import com.tistory.johnmark.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {

	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}

	@Bean
	public MemoryMemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}

	@Bean
	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}

	@Bean
	public DiscountPolicy discountPolicy() {
		// return new FixDiscountPolicy();
		return new RateDiscountPolicy();
	}
}