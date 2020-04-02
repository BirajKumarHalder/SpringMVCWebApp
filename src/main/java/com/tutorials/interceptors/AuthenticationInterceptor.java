package com.tutorials.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.tutorials.models.User;

public class AuthenticationInterceptor implements HandlerInterceptor {

	private static final Log LOGGER = LogFactory.getLog(AuthenticationInterceptor.class);

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		LOGGER.info("Checking authentication");
		User user = (User) request.getSession().getAttribute("loggedInUser");
		if (user == null) {
			LOGGER.info("Authentication failed");
			response.sendRedirect(request.getContextPath() + "/login");
		}
		LOGGER.info("Authentication success");
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		LOGGER.info("Authentication postHandle");
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {
		LOGGER.info("Authentication afterCompletion");
	}

}