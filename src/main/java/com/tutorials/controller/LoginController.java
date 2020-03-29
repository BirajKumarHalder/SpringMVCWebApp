package com.tutorials.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tutorials.exceptions.AuthenticationException;
import com.tutorials.exceptions.UserNotFoundException;
import com.tutorials.models.LoginRq;
import com.tutorials.models.User;
import com.tutorials.services.UserService;

@Controller
public class LoginController extends BaseController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView baseHandler() {
		return new ModelAndView("login", "loginForm", new LoginRq());
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginGetHandler() {
		return new ModelAndView("login", "loginForm", new LoginRq());
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPostHandler(@ModelAttribute("loginForm") LoginRq loginRq, HttpServletRequest request)
			throws AuthenticationException, UserNotFoundException {
		UserService userService = (UserService) context.getBean("userService");
		ModelAndView modelAndView = null;
		if (userService.validateCredentials(loginRq.getUserId(), loginRq.getPassword())) {
			User user = userService.retrieveUserDetails(loginRq.getUserId());
			if (user == null) {
				throw new UserNotFoundException("No user found!");
			}
			request.getSession().setAttribute("loggedInUser", user);
			modelAndView = new ModelAndView("home", "user", user);
		} else {
			throw new AuthenticationException("Invalid credentials!");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logoutGetHandler(HttpServletRequest request) {
		request.getSession().invalidate();
		return new ModelAndView("login", "loginForm", new LoginRq());
	}

	@ExceptionHandler(AuthenticationException.class)
	public ModelAndView handleAuthenticationException(AuthenticationException e) {
		System.out.println("Auth Exception");
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("error", e.getErrorMessage());
		modelAndView.addObject("loginForm", new LoginRq());
		return modelAndView;
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ModelAndView handleUserNotFoundException(UserNotFoundException e) {
		System.out.println("User Not Found Exception");
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("error", e.getErrorMessage());
		modelAndView.addObject("loginForm", new LoginRq());
		return modelAndView;
	}

}
