package com.tistory.johnmark.core;

import com.tistory.johnmark.core.discount.DiscountPolicy;
import com.tistory.johnmark.core.discount.FixDiscountPolicy;
import com.tistory.johnmark.core.member.MemberService;
import com.tistory.johnmark.core.member.MemberServiceImpl;
import com.tistory.johnmark.core.member.MemoryMemberRepository;
import com.tistory.johnmark.core.order.OrderService;
import com.tistory.johnmark.core.order.OrderServiceImpl;

public class AppConfig {

	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}

	private MemoryMemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}

	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}

	private DiscountPolicy discountPolicy() {
		return new FixDiscountPolicy();
	}
}
