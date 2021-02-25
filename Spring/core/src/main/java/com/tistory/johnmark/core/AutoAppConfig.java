package com.tistory.johnmark.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
	excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
	/**
	 * @ComponentScan 은 @Component가 붙은 클래스들을 찾아서 Bean으로 등록해준다.
	 */
}
