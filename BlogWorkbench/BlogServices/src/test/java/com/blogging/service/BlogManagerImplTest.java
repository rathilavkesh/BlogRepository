package com.blogging.service;

import static org.mockito.Mockito.*;

import java.util.Date;




import org.junit.Assert;

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
	
	@Test
	public void shouldRetrieveTheBlogUsingTheId() {
		Blog blog = createBlog();
		when(blogRepository.findOne(any(ObjectId.class))).thenReturn(blog);
		Blog retrievedBlog = blogService.retrieve(new ObjectId());
		verify(blogRepository, times(1)).findOne(any(ObjectId.class));
		Assert.assertEquals(retrievedBlog.getContent(), blog.getContent());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowAErrorWhenObjectIdPassedForRetreivalIsNull() {
		blogService.retrieve(null);
	}

}
