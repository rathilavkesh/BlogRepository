package com.blogging.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
	
	@RequestMapping("/")
    String home() {
		logger.debug("Hello Debug");
		logger.info("Hello info");
        return "Hello World!";
    }

}
