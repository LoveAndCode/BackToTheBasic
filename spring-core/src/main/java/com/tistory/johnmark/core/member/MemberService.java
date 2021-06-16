package com.tistory.johnmark.core.member;

public interface MemberService {
	void join(Member member);
	Member findByMemberId(Long memberId);
}
