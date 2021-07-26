package com.tistory.johnmark.javareflection.logging;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;

@Component
public class MaskingLayout extends PatternLayout {
	@Override
	public String doLayout(ILoggingEvent event) {
		return maskingProcess(event);
	}

	private String maskingProcess(ILoggingEvent event) {
		System.out.println(event);
		for (Object o : event.getArgumentArray()) {
			Arrays.stream(o.getClass().getDeclaredFields()).forEach(f -> {
				if (f.getAnnotation(Masking.class) != null) {
					System.out.println(f.getName() + " is Masking Annotation annotated field");
					try {
						f.setAccessible(true);
						f.set(o, "**********************");
						System.out.println(f.get(o));
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			});
			System.out.println("o = " + o);
		}
		System.out.println(event);
		return super.doLayout(event);
	}

}
