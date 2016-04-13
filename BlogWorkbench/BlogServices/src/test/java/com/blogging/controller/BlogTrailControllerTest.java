package com.blogging.controller;

import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.annotation.Resource;

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

import com.blogging.model.BlogTrail;
import com.blogging.service.BlogManager;
import com.blogging.utils.BlogDataGenerator;
import com.blogging.utils.TestUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { BlogTrailControllerTest.Config.class })
@WebAppConfiguration
public class BlogTrailControllerTest {

	private MockMvc mockMvc;

	@Resource
	private BlogManager blogManager;

	@Resource
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.build();
	}
	
	@Test
	public void shouldStoreTheBlogTrail() throws Exception {
		BlogTrail blogTrail = BlogDataGenerator.createTrail();
		Mockito.doNothing().when(blogManager).storeBlogTrail(any(BlogTrail.class));
		byte[] arr = TestUtils.serialize(blogTrail);
		mockMvc.perform(
				post("/blogtrail/add").content(arr).contentType(
						MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	
	@Configuration
	@EnableWebMvc
	public static class Config {

		@Bean
		public BlogManager blogManager() {
			return Mockito.mock(BlogManager.class);
		}

		@Bean
		public BlogTrailController blogTrailController() {
			return new BlogTrailController();
		}

	}

}
