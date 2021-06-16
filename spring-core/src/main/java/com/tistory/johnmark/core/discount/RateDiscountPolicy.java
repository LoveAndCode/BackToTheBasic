package com.tistory.johnmark.core.discount;

import org.springframework.stereotype.Component;

import com.tistory.johnmark.core.annotation.MainDiscountPolicy;
import com.tistory.johnmark.core.member.Grade;
import com.tistory.johnmark.core.member.Member;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {
	private static final int DISCOUNT_PERCENT = 20;

	@Override
	public int discount(Member member, int price) {
		if (member.getGrade() == Grade.VIP) {
			return price * DISCOUNT_PERCENT / 100;
		}
		return 0;
	}
}
