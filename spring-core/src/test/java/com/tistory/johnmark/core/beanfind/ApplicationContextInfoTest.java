package com.tistory.johnmark.core.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tistory.johnmark.core.AppConfig;

public class ApplicationContextInfoTest {
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	@DisplayName("모든 빈 출력하기")
	void findAllBean() {
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			Object bean = applicationContext.getBean(beanDefinitionName);
			System.out.println("name = " + beanDefinitionName + " Object = " + bean);
		}
	}

	@Test
	@DisplayName("모든 어플리케이션 빈 출력하기")
	void findAllApplicationBean() {
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition beanDefinition = applicationContext.getBeanDefinition(beanDefinitionName);

			// ROLE_APPLICATION : 직접 등록한 애플리케이션 빈
			if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
				Object bean = applicationContext.getBean(beanDefinitionName);
				System.out.println("[APPLICATION_BEAN] name = " + beanDefinitionName + " Object = " + bean);
			}


			// ROLE_INFRASTRUCTURE : 스프링 내부에서 사용하는 빈
			if (beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE) {
				Object bean = applicationContext.getBean(beanDefinitionName);
				System.out.println("[INFRASTRUCTURE_BEAN] name = " + beanDefinitionName + " Object = " + bean);
			}
		}
	}
}
