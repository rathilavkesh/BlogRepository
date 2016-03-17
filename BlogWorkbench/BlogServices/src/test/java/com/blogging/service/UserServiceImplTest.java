package com.blogging.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import com.blogging.model.User;
import com.blogging.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration
public class UserServiceImplTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserService userService = new UserServiceImpl();

	@Test
	public void shouldCallUserRepositoryToStoreTheUser() {
		User user = new User();
		userService.createUser(user);
		verify(userRepository, times(1)).save(user);
	}

}
