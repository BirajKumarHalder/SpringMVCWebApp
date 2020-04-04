package com.tutorials.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController extends BaseController {

	private static final Logger LOGGER = Logger.getLogger(HomeController.class);

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homeGetHandler() {
		LOGGER.debug("/home : GET");
		return "home";
	}

}