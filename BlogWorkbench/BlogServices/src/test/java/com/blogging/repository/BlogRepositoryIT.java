package com.blogging.repository;

import javax.annotation.Resource;
import javax.validation.ConstraintViolationException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blogging.BlogConfiguration;
import com.blogging.model.Blog;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { BlogConfiguration.class })
public class BlogRepositoryIT {

	@Resource
	public BlogRepository blogRepository;
	
	@Test
	public void shouldSaveTheBlog() {
		Blog blog = BlogDataGenerator.createBlog();
		blogRepository.save(blog);
		Assert.assertNotNull(blog);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSubmittedByIsNull() {
		Blog blog = BlogDataGenerator.createBlog();
		blog.setSubmittedBy(null);
		blogRepository.save(blog);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowErrorWhenSubmittedDateIsNull() {
		Blog blog = BlogDataGenerator.createBlog();
		blog.setSubmittedDate(null);
		blogRepository.save(blog);
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowErrorWhenDescriptionAndNameIsNotValid() {
		Blog blog = BlogDataGenerator.createBlog();
		blog.setDescription("Descr");
		blog.setContent("Content");
		blogRepository.save(blog);
	}
	
	@Test
	public void shouldGetTheSavedBlog() {
		Blog blog = BlogDataGenerator.createBlog();
		blogRepository.save(blog);
		Blog savedBlog = blogRepository.findOne(blog.getBlogId());
		Assert.assertEquals(savedBlog.getContent(), blog.getContent());
	}

	@After
	public void after() {
		blogRepository.deleteAll();
	}
}
