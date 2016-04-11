package com.blogging.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Date;

import javax.annotation.Resource;

import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.blogging.model.Country;
import com.blogging.model.User;
import com.blogging.model.UserDetail;
import com.blogging.service.UserManager;
import com.blogging.utils.TestUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UserControllerTest.Config.class })
@WebAppConfiguration
public class UserControllerTest {

	private MockMvc mockMvc;

	@Resource
	private UserManager userService;

	@Resource
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.build();
	}

	@Test
	public void shouldHitProperEndpointToStoreTheUser() throws Exception {
		User user = generateUser();
		Mockito.when(userService.createUser(any(User.class))).thenReturn(user);
		byte[] arr = TestUtils.serialize(user);
		mockMvc.perform(
				post("/user/add").content(arr).contentType(
						MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.firstName", is("TestName")));
	}

	private User generateUser() {
		User user = new User();
		user.setFirstName("TestName");
		user.setLastName("TestLastName");
		user.setCreatedDate(new Date());
		user.setEmail("test");
		Byte b = 0X0;
		user.setIsActive(b);
		user.setUserId(new ObjectId());
		user.setRoleId(Arrays.asList(new ObjectId()));
		user.setCreatedDate(new Date());
		user.setUpdatedDate(new Date());
		UserDetail details = new UserDetail();
		details.setCity("Test");
		details.setCompany("abc");
		details.setCountry(new Country());
		details.setOccupation("abd");
		details.setState("test");
		details.setUserDetailsId(new ObjectId());
		details.setZipCode("1234");
		user.setUserDetail(details);
		return user;
	}

	@Configuration
	@EnableWebMvc
	public static class Config {

		@Bean
		public UserManager userService() {
			return Mockito.mock(UserManager.class);
		}

		@Bean
		public UserController userController() {
			return new UserController();
		}

	}

}
