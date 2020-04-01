package com.tutorials.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController extends BaseController {

	private static final Log LOGGER = LogFactory.getLog(HomeController.class);

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homeGetHandler() {
		LOGGER.debug("HomeController : /home : GET");
		return "home";
	}
}