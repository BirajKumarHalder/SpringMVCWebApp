package com.tutorials.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tutorials.exceptions.UserNotFoundException;
import com.tutorials.models.User;
import com.tutorials.services.UserService;

@Controller
public class RetrieveUserDetailsController extends BaseController {

	private static final Log LOGGER = LogFactory.getLog(RetrieveUserDetailsController.class);

	@RequestMapping(value = "retrieveUserDetails", method = RequestMethod.GET)
	public ModelAndView retrieveUserDetailsGetHandler(@RequestParam() String userId) throws UserNotFoundException {
		LOGGER.info("RetrieveUserDetailsController : /retrieveUserDetails : GET");
		UserService userService = (UserService) context.getBean("userService");
		User user = userService.retrieveUserDetails(userId);
		if (user == null) {
			throw new UserNotFoundException("No user found!");
		}
		return new ModelAndView("userDetails", "user", user);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ModelAndView handleUserNotFoundException(UserNotFoundException e) {
		LOGGER.info("User Not Found Exception");
		ModelAndView modelAndView = new ModelAndView("userDetails");
		modelAndView.addObject("error", e.getErrorMessage());
		modelAndView.addObject("user", new User());
		return modelAndView;
	}
}