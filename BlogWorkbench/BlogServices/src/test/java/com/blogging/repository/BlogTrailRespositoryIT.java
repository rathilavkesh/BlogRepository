package com.blogging.repository;

import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blogging.BlogConfiguration;
import com.blogging.model.Blog;
import com.blogging.model.BlogTrail;
import com.blogging.utils.BlogDataGenerator;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { BlogConfiguration.class })
public class BlogTrailRespositoryIT {

	@Autowired
	private BlogRepository blogRepo;
	
	@Autowired
	private BlogTrailRepository trailRepo;
	
	
	@Test
	public void shouldStoreTheTrailInDatabase() {
		//Build
		BlogTrail trail = BlogDataGenerator.createTrail();
		//Execute
		BlogTrail savedTrail = trailRepo.save(trail);
		//Verify
		Assert.assertNotNull(savedTrail);
	}
	
	
	@Test
	public void shouldGetTheTrailBasedonIds() {
		//Build
		Blog blog = BlogDataGenerator.createBlog();
		BlogTrail trail = BlogDataGenerator.createTrail();
		BlogTrail savedTrail = trailRepo.save(trail);
		blog.setBlogTrailIds(Arrays.asList(savedTrail.getBlogTrailId()));
		blogRepo.save(blog);
		
		//Execute
		Page<BlogTrail> trails = trailRepo.findAll(new PageRequest(0, 10));
		
		//Verify
		Assert.assertEquals(savedTrail.getBlogTrailId(), trails.getContent().get(0).getBlogTrailId());
		
	}
	
	
	@After
	public void after() {
		blogRepo.deleteAll();
		trailRepo.deleteAll();
	} 

}
