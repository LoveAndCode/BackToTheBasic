package com.tistory.johnmark.core;

import com.tistory.johnmark.core.member.Grade;
import com.tistory.johnmark.core.member.Member;
import com.tistory.johnmark.core.member.MemberService;
import com.tistory.johnmark.core.member.MemberServiceImpl;

public class MemberApp {

	public static void main(String[] args) {
		MemberService memberService = new MemberServiceImpl();
		Member member = new Member(1L, "MemberA", Grade.VIP);
		memberService.join(member);

		Member findMember = memberService.findByMemberId(1L);
		System.out.println("new Member = " + member.getName());
		System.out.println("find Member = " + findMember.getName());
	}
}
