package com.tistory.johnmark.core.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tistory.johnmark.core.common.MyLogger;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
	private final LogDemoService logDemoService;
	private final MyLogger myLogger;

	@RequestMapping("log-demo")
	@ResponseBody
	public String logDemo(HttpServletRequest request) {
		String requestUrl = request.getRequestURL().toString();
		myLogger.setRequestUrl(requestUrl);
		myLogger.log("controller start");
		logDemoService.logic("testId");
		return "OK";
	}
}
