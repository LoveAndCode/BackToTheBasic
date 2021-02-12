package com.tistory.johnmark.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.tistory.johnmark.core.member.MemoryMemberRepository;

@Configuration
@ComponentScan(
	excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
	/**
	 * @ComponentScan 은 @Component가 붙은 클래스들을 찾아서 Bean으로 등록해준다.
	 */

	/**
	 *
	 * 수동 빈 등록시, 자동 빈과 충돌이 나는 경우 수동 빈이 우선권을 가져 덮어씌여진다.
	 */
	@Bean(name = "memoryMemberRepository")
	MemoryMemberRepository memoryMemberRepository(){
		return new MemoryMemberRepository();
	}
}
