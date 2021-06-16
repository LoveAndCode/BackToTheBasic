package com.tistory.johnmark.core.singleton;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tistory.johnmark.core.AppConfig;
import com.tistory.johnmark.core.member.MemberRepository;
import com.tistory.johnmark.core.member.MemberServiceImpl;
import com.tistory.johnmark.core.order.OrderServiceImpl;

public class ConfigurationSingletonTest {
	@Test
	void configurationTest() {
		/**
		 *  AppConfig@CGLIB 예상 코드
		 * @Bean
		 * public MemberRepository memberRepository(){
		 * if(memoryRepository 가 스프링 컨테이너에 있다면) {
		 *  return 존재하는 bean을 반환;
		 *  }
		 *  return 새로 객체를 만들고 bean을 반환
		 */
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
			AppConfig.class);

		MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
		OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
		MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

		MemberRepository memberRepository1 = memberService.getMemberRepository();
		MemberRepository memberRepository2 = orderService.getMemberRepository();

		System.out.println("memberService -> memberRepository = " + memberRepository);
		System.out.println("orderService -> memberRepository1 = " + memberRepository1);
		System.out.println("memberRepository2 = " + memberRepository2);

		assertThat(memberRepository1).isSameAs(memberRepository2).isSameAs(memberRepository);
	}

	/**
	 * AppConfig@CGLIB 예상 코드
	 * @Bean
	 * public MemberRepository memberRepository(){
	 *     if(memoryMemberRepository 가 이미 스프링 컨테이너에 있으면) {
	 *         return 스프링 컨테이너에서 찾아서 반환
	 *     }
	 *     기존 로직을 호출해서 MemoryMemberRepository를 생성하고 스프링 컨테이너에 등록
	 *     return 반환
	 * }
	 */
	@Test
	void configurationDeep() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		AppConfig bean = ac.getBean(AppConfig.class);
		System.out.println("bean = " + bean);
	}
}
