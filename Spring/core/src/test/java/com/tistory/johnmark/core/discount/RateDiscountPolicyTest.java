package com.tistory.johnmark.core.discount;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.tistory.johnmark.core.member.Grade;
import com.tistory.johnmark.core.member.Member;
import com.tistory.johnmark.core.member.MemberRepository;
import com.tistory.johnmark.core.member.MemoryMemberRepository;

class RateDiscountPolicyTest {
	DiscountPolicy discountPolicy = new RateDiscountPolicy();
	MemberRepository memberRepository = new MemoryMemberRepository();

	@Test
	@DisplayName("VIP는 20% 할인이 적용되어야 한다.")
	void vip_o() {
		//given
		Member member = new Member(1L, "memberVIP", Grade.VIP);
		//when
		int discount = discountPolicy.discount(member, 10000);
		//then
		assertThat(discount).isEqualTo(2000);
	}

	@Test
	@DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
	void vip_x() {
		//given
		Member member = new Member(1L, "memberVIP", Grade.BASIC);
		//when
		int discount = discountPolicy.discount(member, 10000);
		//then
		assertThat(discount).isNotEqualTo(1000);
	}

}