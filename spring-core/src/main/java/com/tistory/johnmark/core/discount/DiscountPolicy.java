package com.tistory.johnmark.core.discount;

import com.tistory.johnmark.core.member.Member;

public interface DiscountPolicy {
	/**
	 * 
	 * @param member - 회원
	 * @param price - 주문 금액
	 * @return 항인 대상 금액
	 */
	int discount(Member member, int price);
}
