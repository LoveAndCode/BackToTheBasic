package com.tistory.johnmark.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
	MemberService memberService = new MemberServiceImpl();

	@Test
	@DisplayName(value = "멤버 등록 및 조회 테스트")
	void join() {
		//given
		Member member = new Member(1L, "MemberA", Grade.VIP);

		//when
		memberService.join(member);
		Member findMember = memberService.findByMemberId(1L);

		//then
		Assertions.assertThat(member).isEqualTo(findMember);
	}
}
