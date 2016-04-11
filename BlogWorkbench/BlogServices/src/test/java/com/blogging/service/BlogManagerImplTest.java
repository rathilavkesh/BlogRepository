package com.blogging.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Date;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.blogging.model.Blog;
import com.blogging.repository.BlogRepository;

@RunWith(MockitoJUnitRunner.class)
public class BlogManagerImplTest {


	@Mock
	private BlogRepository blogRepository;

	@InjectMocks
	private BlogManager blogService = new BlogManagerImpl();
	
	
	
	
	private Blog createBlog() {
		Blog blog = new Blog();
		blog.setContent("Test Content");
		blog.setDescription("Test Description");
		blog.setSubmittedBy(new ObjectId());
		blog.setSubmittedDate(new Date());
		return blog;
	}
	
	@Test
	public void shouldStoreTheBlog() {
		Blog blog = createBlog();
		blogService.createBlog(blog);
		verify(blogRepository, times(1)).save(blog);
	}

}
