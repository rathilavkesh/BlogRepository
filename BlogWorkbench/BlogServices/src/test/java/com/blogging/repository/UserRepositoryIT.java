package com.blogging.repository;

import java.util.Date;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blogging.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { UserRepositoryIT.Config.class })
public class UserRepositoryIT {

	@Resource
	private UserRepository userRepo;

	private User user;

	@Before
	public void setUp() {
		createUser();
	}

	private void createUser() {
		user = new User();
		user.setCreatedDate(new Date());
		user.setFirstName("TestName");
		user.setEmail("abc@abc.com");
		user.setLastName("TestLastName");
		user.setPassword("test");
	}

	@Test
	public void test() {
		User savedUser = userRepo.save(user);
		Assert.assertNotNull(savedUser);
		Assert.assertEquals("TestName", savedUser.getFirstName());
	}
	
	@After
	public void after() {
		userRepo.deleteAll();
	}

	@Configuration
	@EnableMongoRepositories(basePackages = { "com.blogging.repository" })
	@EntityScan(basePackages = { "com.blogging.model" })
	@EnableAutoConfiguration
	public static class Config {
	}

}
