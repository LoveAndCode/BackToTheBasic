package com.tistory.johnmark.core;

import com.tistory.johnmark.core.discount.FixDiscountPolicy;
import com.tistory.johnmark.core.member.MemberService;
import com.tistory.johnmark.core.member.MemberServiceImpl;
import com.tistory.johnmark.core.member.MemoryMemberRepository;
import com.tistory.johnmark.core.order.OrderService;
import com.tistory.johnmark.core.order.OrderServiceImpl;

public class AppConfig {

	public MemberService memberService(){
		return new MemberServiceImpl(new MemoryMemberRepository());
	}

	public OrderService orderService(){
		return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
	}
}
