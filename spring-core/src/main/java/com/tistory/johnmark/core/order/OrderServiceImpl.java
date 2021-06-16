package com.tistory.johnmark.core.order;

import org.springframework.stereotype.Component;

import com.tistory.johnmark.core.annotation.MainDiscountPolicy;
import com.tistory.johnmark.core.discount.DiscountPolicy;
import com.tistory.johnmark.core.member.Member;
import com.tistory.johnmark.core.member.MemberRepository;

@Component
public class OrderServiceImpl implements OrderService {
	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy;

	public OrderServiceImpl(
		MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy
	) {
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}

	/**
	 * 멤버 변수가 불변 객체로 선언되어있고, 해당 객체를 인자로 받는
	 * 인자있는 생성자가 한개만 선언되어있는 경우, @Autowired를 선언 안해도
	 * 스프링에서는 자동으로 스프링 빈을 찾아서 주입을한다.
	 */
	// public OrderServiceImpl(
	// 	MemberRepository memberRepository, DiscountPolicy discountPolicy
	// ) {
	// 	System.out.println("memberRepository = " + memberRepository);
	// 	System.out.println("discountPolicy = " + discountPolicy);
	// 	this.memberRepository = memberRepository;
	// 	this.discountPolicy = discountPolicy;
	// }
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
