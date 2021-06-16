package com.tistory.johnmark.core.member;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	private final MemberRepository memberRepository;

	@Override
	public void join(Member member) {
		memberRepository.save(member);
	}

	@Override
	public Member findByMemberId(Long memberId) {
		return memberRepository.findById(memberId);
	}

	// 테스트용
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}
}
