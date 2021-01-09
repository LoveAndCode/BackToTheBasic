package com.tistory.johnmark.core.beandefinition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.tistory.johnmark.core.AppConfig;

public class BeanDefinitionTest {
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
	// GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext("appConfig.xml");


	@Test
	@DisplayName("빈 설정 메타 정보 확인")
	void findApplicationBean() {
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition beanDefinition = applicationContext.getBeanDefinition(beanDefinitionName);

			if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
				System.out.println("BeanDefinitionName = " + beanDefinitionName + " beanDefinition = " + beanDefinition);
			}
		}
	}
}
