package com.tistory.johnmark.javareflection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.tistory.johnmark.javareflection.logging.LogDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class JavaReflectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaReflectionApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void test() {
		LogDTO logDTO = new LogDTO("Normal Message", "Sensitive Message", 13);
		log.info("Application Ready Event Log :: {} ", logDTO);
	}

}
