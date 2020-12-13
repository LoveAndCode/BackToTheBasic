package com.tistory.johnmark.core;

import com.tistory.johnmark.core.member.Grade;
import com.tistory.johnmark.core.member.Member;
import com.tistory.johnmark.core.member.MemberService;
import com.tistory.johnmark.core.member.MemberServiceImpl;
import com.tistory.johnmark.core.order.Order;
import com.tistory.johnmark.core.order.OrderService;
import com.tistory.johnmark.core.order.OrderServiceImpl;

public class OrderApp {
	public static void main(String[] args) {
		MemberService memberService = new MemberServiceImpl();
		OrderService orderService = new OrderServiceImpl();

		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);

		Order order = orderService.createOrder(memberId, "itemA", 10000);
		System.out.println("Order = "+order);
		System.out.println("Order Price = "+order.calculatePrice());
	}
}
