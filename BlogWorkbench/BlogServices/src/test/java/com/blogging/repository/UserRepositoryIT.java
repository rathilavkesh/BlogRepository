package com.blogging.repository;

import static org.junit.Assert.fail;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blogging.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {UserRepositoryIT.Config.class})
public class UserRepositoryIT {
	
	@Resource
	private UserRepository userRepo;

	@Test
	public void test() {
		
		User user = new User();
		user.setCreatedDate(new Date());
		user.setFirstName("TestName");
		user.setEmail("abc@abc.com");
		user.setLastName("TestLastName");
		user.setPassword("test");
		
		System.out.println("userRepo "+ userRepo);
		
		User save = userRepo.save(user);
		System.out.println("save" + save.getUserId());
		
	}
	
	
	@Configuration
	@EnableMongoRepositories(basePackages={"com.blogging.repository"})
	@EntityScan(basePackages={"com.blogging.model"})
	@ImportResource(locations={"classpath:META-INF/spring-data-embedded-mongo.xml"})
	@EnableAutoConfiguration(exclude={EmbeddedMongoAutoConfiguration.class})
	public static class Config {
		
	}

}
