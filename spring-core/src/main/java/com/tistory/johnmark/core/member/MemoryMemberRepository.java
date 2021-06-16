package com.tistory.johnmark.core.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MemoryMemberRepository implements MemberRepository{
	private static final Map<Long, Member> STORE = new HashMap<>();

	@Override
	public void save(Member member) {
		STORE.put(member.getId(), member);
	}

	@Override
	public Member findById(Long memberId) {
		return STORE.get(memberId);
	}
}
