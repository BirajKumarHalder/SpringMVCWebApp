package com.tutorials.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tutorials.models.User;
import com.tutorials.services.UserService;

@Controller
public class RetrieveUserDetailsController extends BaseController {

	@RequestMapping(value = "retrieveUserDetails", method = RequestMethod.GET)
	public ModelAndView retrieveUserDetailsGetHandler(@RequestParam() String userId) {
		UserService userService = (UserService) context.getBean("userService");
		User user = userService.retrieveUserDetails(userId);
		return new ModelAndView("userDetails", "user", user);
	}
}