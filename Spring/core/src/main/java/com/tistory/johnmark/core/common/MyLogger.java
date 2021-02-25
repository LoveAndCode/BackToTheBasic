package com.tistory.johnmark.core.common;

import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class MyLogger {
	private String uuid;
	private String requestUrl;

	@PostConstruct
	public void init() {
		this.uuid = UUID.randomUUID().toString();
		System.out.println("[" + uuid + "]" + " request scope bean create: " + this);
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public void log(String message) {
		System.out.println("[" + uuid + "]" + " [" + requestUrl + "]" + "[" + message + "]");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("[" + uuid + "]" + " request scope bean close: " + this);
	}
}
