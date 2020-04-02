package com.tutorials.interceptors;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LogInterceptor implements HandlerInterceptor {

	private static final Logger LOGGER = Logger.getLogger(LogInterceptor.class);

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String ipAddress = request.getRemoteAddr();
		String requestUri = ((HttpServletRequest) request).getRequestURI();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss z");
		String currentTime = sdf.format(date);
		LOGGER.info("LogInterceptor: <Requested Uri: " + requestUri + ">< IP : " + ipAddress + "><Time : " + currentTime
				+ ">");
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss z");
		String currentTime = sdf.format(date);
		LOGGER.info("LogInterceptor postHandle: <Time : " + currentTime + ">");
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss z");
		String currentTime = sdf.format(date);
		LOGGER.info("LogInterceptor afterCompletion: <Time : " + currentTime + ">");
	}

}