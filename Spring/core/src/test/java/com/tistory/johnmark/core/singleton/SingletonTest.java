package com.tistory.johnmark.core.singleton;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.tistory.johnmark.core.AppConfig;
import com.tistory.johnmark.core.member.MemberService;

public class SingletonTest {

	@Test
	@DisplayName("스프링 없는 순수한 DI 컨테이너")
	void pureContainer() {
		AppConfig appConfig = new AppConfig();
		// 1.조회: 호출할때 마다 객체 생성
		MemberService memberService = appConfig.memberService();

		// 2.조회: 호출할때 마다 객체 생성
		MemberService memberService1 = appConfig.memberService();

		// 참조값이 다른 것을 확인
		System.out.println("memberService = " + memberService);
		System.out.println("memberService = " + memberService1);

		assertThat(memberService).isNotSameAs(memberService1);
	}

	@Test
	@DisplayName("싱글톤 테스트")
	void singleTonTest() {
		SingletonService singletonService = SingletonService.getInstance();
		SingletonService singletonService1 = SingletonService.getInstance();

		System.out.println("singletonService =" + singletonService);
		System.out.println("singletonService1 =" + singletonService1);

		assertThat(singletonService).isSameAs(singletonService1);
	}
}
