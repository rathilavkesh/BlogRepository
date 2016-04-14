package com.blogging.repository;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
		// Build
		BlogTrail trail = BlogDataGenerator.createTrail();
		// Execute
		BlogTrail savedTrail = trailRepo.save(trail);
		// Verify
		Assert.assertNotNull(savedTrail);
	}

	@Test
	public void shouldGetTheTrailBasedonIds() {
		// Build
		Blog blog = BlogDataGenerator.createBlog();
		BlogTrail trail = BlogDataGenerator.createTrail();
		BlogTrail savedTrail = trailRepo.save(trail);
		blog.setBlogTrailIds(Arrays.asList(savedTrail.getBlogTrailId()));
		blogRepo.save(blog);

		// Execute
		Page<BlogTrail> trails = trailRepo.findAll(new PageRequest(0, 10));

		// Verify
		Assert.assertEquals(savedTrail.getBlogTrailId(), trails.getContent()
				.get(0).getBlogTrailId());

	}

	@Test
	public void shouldRetrievethiTrailsBasedOnBlogId() {
		// Build
		Blog blog = BlogDataGenerator.createBlog();
		Blog savedBlog = blogRepo.save(blog);
		BlogTrail trail = BlogDataGenerator.createTrail();
		trail.setSubmittedDate(new Date());
		trail.setBlogId(savedBlog.getBlogId());
		BlogTrail savedTrail = trailRepo.save(trail);
		BlogTrail trail1 = BlogDataGenerator.createTrail();
		trail1.setSubmittedDate(new Date());
		trail1.setBlogId(savedBlog.getBlogId());
		BlogTrail savedTrail1 = trailRepo.save(trail1);
		blog.setBlogTrailIds(Arrays.asList(savedTrail.getBlogTrailId(), savedTrail1.getBlogTrailId()));
		savedBlog = blogRepo.save(blog);
		
		//Execute
		List<BlogTrail> trails = trailRepo.findAllByBlogId(savedBlog.getBlogId(), new PageRequest(0, 1, new Sort(Direction.DESC, "submittedDate")));
		
		//Verify
		Assert.assertEquals(trails.get(0).getBlogTrailId(), savedTrail1.getBlogTrailId());
	}

	@After
	public void after() {
		blogRepo.deleteAll();
		trailRepo.deleteAll();
	}

}
