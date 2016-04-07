package com.blogging.repository;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blogging.BlogConfiguration;
import com.blogging.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { BlogConfiguration.class })
public class UserRepositoryIT {

	@Resource
	private UserRepository userRepo;


	@Before
	public void setUp() {
		createUser();
	}

	private User createUser() {
		User user = new User();
		user.setCreatedDate(new Date());
		user.setFirstName("TestName");
		user.setEmail("abc@abc.com");
		user.setLastName("TestLastName");
		user.setPassword("test");
		return user;
	}

	@Test
	public void shouldSaveTheUser() {
		User savedUser = userRepo.save(createUser());
		Assert.assertNotNull(savedUser);
		Assert.assertEquals("TestName", savedUser.getFirstName());
	}
	
	@After
	public void after() {
		userRepo.deleteAll();
	}
}