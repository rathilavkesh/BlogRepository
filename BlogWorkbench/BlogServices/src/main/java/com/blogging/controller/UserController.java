package com.blogging.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blogging.model.User;
import com.blogging.service.UserService;

@RestController
public class UserController {

	@Resource
	private UserService userService;
	
	@RequestMapping(value="/user/add", produces="application/json", consumes="application/json", method=RequestMethod.POST)
    public User save(@RequestBody User user) {
        return userService.createUser(user);
    }
}
