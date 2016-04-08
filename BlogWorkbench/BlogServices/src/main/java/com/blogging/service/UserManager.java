package com.blogging.service;

import com.blogging.model.User;

public interface UserManager {
	/**
	 * This service API is responsible for creating user.
	 * 
	 * @param user user meta information in the form of bean
	 * @return returns the created object
	 */
	public User createUser(User user);
	
}
