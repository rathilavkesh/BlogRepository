package com.blogging.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.blogging.model.Blog;
import com.blogging.model.BlogTrail;
import com.blogging.repository.BlogRepository;
import com.blogging.repository.BlogTrailRepository;
import com.blogging.utils.BlogDataGenerator;

@RunWith(MockitoJUnitRunner.class)
public class BlogManagerImplTest {


	@Mock
	private BlogRepository blogRepository;
	
	@Mock
	private BlogTrailRepository blogTrailRepo;

	@InjectMocks
	private BlogManager blogService = new BlogManagerImpl();
	
	@Test
	public void shouldStoreTheTrailForTheBlog() {
		
	}
	
	@Test
	public void shouldStoreTheBlog() {
		Blog blog = BlogDataGenerator.createBlog();
		blogService.createBlog(blog);
		verify(blogRepository, times(1)).save(blog);
	}
	
	@Test
	public void shouldRetrieveTheBlogUsingTheId() {
		Blog blog = BlogDataGenerator.createBlog();
		when(blogRepository.findOne(any(ObjectId.class))).thenReturn(blog);
		Blog retrievedBlog = blogService.retrieve(new ObjectId());
		verify(blogRepository, times(1)).findOne(any(ObjectId.class));
		Assert.assertEquals(retrievedBlog.getContent(), blog.getContent());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowAErrorWhenObjectIdPassedForRetreivalIsNull() {
		blogService.retrieve(null);
	}
	
	@Test
	public void shouldStoreBlogTrail() {
		BlogTrail trail = BlogDataGenerator.createTrail();
		blogService.storeBlogTrail(trail);
		verify(blogTrailRepo, times(1)).save(trail);
		verify(blogRepository, times(1)).findOne(any(ObjectId.class));
		verify(blogRepository, times(1)).save(any(Blog.class));
	}
	
//	@Test
//	public void shouldRetrieveTheBlogTrailsBasedOnBlogId() {
//		
//		blogService.retrieveTrails(trailIds);
//		when(blogRepository.find)
//	}

}
