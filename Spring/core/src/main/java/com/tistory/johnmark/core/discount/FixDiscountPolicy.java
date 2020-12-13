package com.tistory.johnmark.core.discount;

import com.tistory.johnmark.core.member.Grade;
import com.tistory.johnmark.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
	private static final int DISCOUNT_FIX_AMOUNT = 1000; // 1000원
	@Override
	public int discount(Member member, int price) {
		if(member.getGrade() == Grade.VIP){
			return DISCOUNT_FIX_AMOUNT;
		}
		return 0;
	}
}
