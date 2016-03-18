package com.blogging.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blogging.model.User;
import com.blogging.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	UserRepository UserRepository;

	@Override
	public User createUser(User user) {
		User savedUser = UserRepository.save(user);
		return savedUser;
	}

}
