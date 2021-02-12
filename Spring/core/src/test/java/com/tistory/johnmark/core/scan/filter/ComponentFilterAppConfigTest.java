package com.tistory.johnmark.core.scan.filter;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

public class ComponentFilterAppConfigTest {

	@Test
	void filterScan() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
			ComponentFilterAppConfig.class);

		BeanA beanA = applicationContext.getBean("beanA", BeanA.class);
		assertThat(beanA).isNotNull();

		assertThrows(NoSuchBeanDefinitionException.class, () ->
			applicationContext.getBean("beanB", BeanB.class)
		);
	}

	/**
	 * FilterType Option
	 * 1. FilterType.ANNOTATION = 기본값, 애노테이션을 인식해서 동작
	 * 2. FilterType.ASSIGNABLE_TYPE = 지정한 타입과 자식타입을 인식해서 동작
	 * 3. FilterType.ASPECTJ = AspectJ 패턴 사용
	 * 4. FilterType.REGEXP = 정규표현식 사용
	 * 5. FilterType.CUSTOM = TypeFilter 이라는 인터페이스를 구현해서 처리
	 */
	@Configuration
	@ComponentScan(
		includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
		excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class)
	)
	public static class ComponentFilterAppConfig {
	}
}
