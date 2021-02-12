package com.tistory.johnmark.core.autowired;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import com.tistory.johnmark.core.member.Member;

public class AutowiredTest {

	@Test
	void autoWiredOption() {
		ApplicationContext context = new AnnotationConfigApplicationContext(TestBean.class);
	}

	static class TestBean {

		/**
		 *  빈 주입 시, require false 이면서, 인자 값(스프링 빈)이 스프링 컨테이너에 없는 경우
		 *  메소드가 호출되지 않는다
		 */
		@Autowired(required = false)
		public void setNoBean1(Member member) {
			System.out.println("member = " + member);
		}

		/**
		 * 빈 주입 시, require true 이면서, @Nullable로 값을 인자로 받는 경우
		 * 인자 값(스프링 빈)이 없어도 메소드가 호출이 된다.
		 */
		@Autowired
		public void setNoBean2(@Nullable Member member) {
			System.out.println("member = " + member);
		}

		/**
		 * 빈 주입 시, require true 이면서, @Optional로 값을 감싸서 인자로 받는 경우
		 * 인자 값(스프링 빈)이 없어도 메소드가 호출이 된다.
		 */
		@Autowired
		public void setNoBean3(Optional<Member> member) {
			System.out.println("member = " + member);
		}
	}
}
