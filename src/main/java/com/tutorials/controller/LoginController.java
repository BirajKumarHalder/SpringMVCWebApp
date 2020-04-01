package com.tutorials.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

	private static final Log LOGGER = LogFactory.getLog(LoginController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView baseHandler() {
		LOGGER.info("LoginController : / : GET");
		return new ModelAndView("login", "loginForm", new LoginRq());
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginGetHandler() {
		LOGGER.info("LoginController : /login : GET");
		return new ModelAndView("login", "loginForm", new LoginRq());
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPostHandler(@ModelAttribute("loginForm") LoginRq loginRq, HttpServletRequest request)
			throws AuthenticationException, UserNotFoundException {
		LOGGER.info("LoginController : /login : POST");
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
		LOGGER.info("Logging out");
		return new ModelAndView("login", "loginForm", new LoginRq());
	}

	@ExceptionHandler(AuthenticationException.class)
	public ModelAndView handleAuthenticationException(AuthenticationException e) {
		LOGGER.info("Auth Exception");
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("error", e.getErrorMessage());
		modelAndView.addObject("loginForm", new LoginRq());
		return modelAndView;
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ModelAndView handleUserNotFoundException(UserNotFoundException e) {
		LOGGER.info("User Not Found Exception");
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("error", e.getErrorMessage());
		modelAndView.addObject("loginForm", new LoginRq());
		return modelAndView;
	}

}
