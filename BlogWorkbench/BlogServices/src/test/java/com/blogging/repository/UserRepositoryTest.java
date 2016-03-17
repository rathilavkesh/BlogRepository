package com.blogging.repository;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blogging.model.User;
import com.blogging.model.UserDetail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {UserRepositoryTest.Config.class})
public class UserRepositoryTest {
	
	@Resource
	private UserRepository repo;
	
	@Test
	public void shouldSaveTheUser() {
		User generatedUser = generateUser();
		User save = repo.save(generatedUser);
		Assert.assertNotNull(save);
		Assert.assertNotNull(save.getUserId());
		User findOne = repo.findOne(save.getUserId());
		Assert.assertNotNull(findOne);
		Assert.assertEquals("TestName", findOne.getFirstName());
	}
	
	private User generateUser() {
		User user = new User();
		user.setCreatedDate(new Date());
		user.setFirstName("TestName");
		user.setEmail("abc@abc.com");
		user.setLastName("TestLastName");
		user.setPassword("test");
		
		UserDetail details = new UserDetail();
		details.setCity("Pune");
		user.setUserDetail(details);
		return user;
	}
	
	@Configuration
	@EntityScan(basePackages={"com.blogging.model"})
	@EnableJpaRepositories(basePackages={"com.blogging.repository"})
	@EnableAutoConfiguration
	public static class Config {}
	
}
