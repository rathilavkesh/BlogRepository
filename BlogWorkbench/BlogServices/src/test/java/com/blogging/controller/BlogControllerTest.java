package com.blogging.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.blogging.model.Blog;
import com.blogging.service.BlogManager;
import com.blogging.utils.TestUtils;
import com.fasterxml.jackson.core.JsonProcessingException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { BlogControllerTest.Config.class })
@WebAppConfiguration
public class BlogControllerTest {
	
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
	public void shouldSaveTheBlog() throws Exception {
		Blog blog = generateBlog();
		Mockito.doNothing().when(blogManager).createBlog(any(Blog.class));
		byte[] arr = TestUtils.serialize(blog);
		mockMvc.perform(
				post("/blog/add").content(arr).contentType(
						MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	private Blog generateBlog() {
		Blog blog = new Blog();
		blog.setSubmittedBy(new ObjectId());
		blog.setSubmittedDate(new Date());
		blog.setContent("Test Content");
		return blog;
	}

	@Configuration
	@EnableWebMvc
	public static class Config {

		@Bean
		public BlogManager blogManager() {
			return Mockito.mock(BlogManager.class);
		}

		@Bean
		public BlogController blogController() {
			return new BlogController();
		}

	}

}
