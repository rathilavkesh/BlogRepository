package com.blogging.repository;

import java.util.Date;

import javax.annotation.Resource;
import javax.validation.ConstraintViolationException;

import org.bson.types.ObjectId;
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
	private BlogRepository blogRepository;

	private Blog createBlog() {
		Blog blog = new Blog();
		blog.setContent("This is Test Blog content.");
		blog.setDescription("This is Test Blog Description.");
		blog.setSubmittedBy(new ObjectId("507f191e810c19729de860ea"));
		blog.setSubmittedDate(new Date());
		return blog;
	}

	@Test
	public void shouldSaveTheBlog() {
		Blog blog = createBlog();
		blogRepository.save(blog);
		Assert.assertNotNull(blog);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSubmittedByIsNull() {
		Blog blog = createBlog();
		blog.setSubmittedBy(null);
		blogRepository.save(blog);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowErrorWhenSubmittedDateIsNull() {
		Blog blog = createBlog();
		blog.setSubmittedDate(null);
		blogRepository.save(blog);
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowErrorWhenDescriptionAndNameIsNotValid() {
		Blog blog = createBlog();
		blog.setDescription("Descr");
		blog.setContent("Content");
		blogRepository.save(blog);
	}
	
	@Test
	public void shouldGetTheSavedBlog() {
		Blog blog = createBlog();
		blogRepository.save(blog);
		Blog savedBlog = blogRepository.findOne(blog.getBlogId());
		Assert.assertEquals(savedBlog.getContent(), blog.getContent());
	}

	@After
	public void after() {
		blogRepository.deleteAll();
	}
}
