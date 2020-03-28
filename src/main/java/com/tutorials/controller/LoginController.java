package com.tutorials.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tutorials.models.LoginRq;
import com.tutorials.models.User;
import com.tutorials.services.UserService;

@Controller
public class LoginController extends BaseController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginGetHandler() {
		return new ModelAndView("login", "loginForm", new LoginRq());
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPostHandler(@ModelAttribute("loginForm") LoginRq loginRq) {
		UserService userService = (UserService) context.getBean("userService");
		ModelAndView modelAndView = null;
		if (userService.validateCredentials(loginRq.getUserId(), loginRq.getPassword())) {
			User user = userService.retrieveUserDetails(loginRq.getUserId());
			modelAndView = new ModelAndView("home", "user", user);
		} else {
			modelAndView = new ModelAndView("login", "error", "Invalid credentials!");
		}
		return modelAndView;
	}

}
