package com.tistory.johnmark.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.tistory.johnmark.core.AppConfig;
import com.tistory.johnmark.core.member.Grade;
import com.tistory.johnmark.core.member.Member;
import com.tistory.johnmark.core.member.MemberService;

public class OrderServiceTest {
	AppConfig appConfig = new AppConfig();
	MemberService memberService = appConfig.memberService();
	OrderService orderService = appConfig.orderService();

	@Test
	@DisplayName("주문 생성 및 할인 확인")
	void createOrder() {
		//given
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		//when
		memberService.join(member);
		Order order = orderService.createOrder(memberId, "itemA", 10000);
		//then
		Assertions.assertThat(member.getId()).isEqualTo(memberId);
		Assertions.assertThat(member.getGrade()).isEqualTo(Grade.VIP);
		Assertions.assertThat(order.getDiscountPrice()).isEqualTo(2000);
	}
}
