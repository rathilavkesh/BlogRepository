package com.blogging.repository;

import java.util.Date;

import javax.annotation.Resource;
import javax.validation.ConstraintViolationException;

import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
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
	public void test() {
		Blog blog = createBlog();
		blogRepository.save(blog);
		Assert.assertNotNull(blog);
	}
	
	@Test
	public void testEmptySubmitBy() {
		Blog blog = createBlog();
		blog.setSubmittedBy(null);
		try{
			blogRepository.save(blog);
			Assert.fail();
		}catch(ConstraintViolationException e){
		}
	}
	
	@Test
	public void testEmptySubmitDate() {
		Blog blog = createBlog();
		blog.setSubmittedDate(null);
		try{
			blogRepository.save(blog);
			Assert.fail();
		}catch(ConstraintViolationException e){
		}
	}
	
	@After
	public void after() {
		blogRepository.deleteAll();
	}
}
