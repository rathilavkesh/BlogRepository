package com.blogging.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.blogging.model.User;
import com.blogging.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserManager userService = new UserManagerImpl();

	@Test
	public void shouldCallUserRepositoryToStoreTheUser() {
		User user = new User();
		userService.createUser(user);
		verify(userRepository, times(1)).save(user);
	}

}
