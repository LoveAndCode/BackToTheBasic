package com.tistory.johnmark.core.order;

import com.tistory.johnmark.core.discount.DiscountPolicy;
import com.tistory.johnmark.core.discount.FixDiscountPolicy;
import com.tistory.johnmark.core.member.Member;
import com.tistory.johnmark.core.member.MemberRepository;
import com.tistory.johnmark.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
	private final MemberRepository memberRepository = new MemoryMemberRepository();
	private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}
}
