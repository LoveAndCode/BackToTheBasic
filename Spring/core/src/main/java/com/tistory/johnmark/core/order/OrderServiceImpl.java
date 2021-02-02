package com.tistory.johnmark.core.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tistory.johnmark.core.discount.DiscountPolicy;
import com.tistory.johnmark.core.member.Member;
import com.tistory.johnmark.core.member.MemberRepository;

@Component
public class OrderServiceImpl implements OrderService {
	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy;

	@Autowired
	public OrderServiceImpl(
		MemberRepository memberRepository, DiscountPolicy discountPolicy
	) {
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}

	//테스트용도
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}
}
