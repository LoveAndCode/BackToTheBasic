package com.tistory.johnmark.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tistory.johnmark.core.member.Grade;
import com.tistory.johnmark.core.member.Member;
import com.tistory.johnmark.core.member.MemberService;
import com.tistory.johnmark.core.order.Order;
import com.tistory.johnmark.core.order.OrderService;

public class OrderApp {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
		OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);

		Order order = orderService.createOrder(memberId, "itemA", 20000);
		System.out.println("Order = " + order);
		System.out.println("Order Price = " + order.calculatePrice());
	}
}
