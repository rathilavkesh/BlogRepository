package com.blogging.service;

import java.util.List;

import javax.annotation.Resource;

import org.bson.types.ObjectId;
import org.springframework.util.Assert;

import com.blogging.model.Blog;
import com.blogging.model.BlogTrail;
import com.blogging.repository.BlogRepository;
import com.blogging.repository.BlogTrailRepository;

public class BlogManagerImpl implements BlogManager{
	
	@Resource
	private BlogRepository blogRepo;
	
	@Resource
	private BlogTrailRepository trailRepo;

	@Override
	public void createBlog(Blog blog) {
		blogRepo.save(blog);
	}

	@Override
	public Blog retrieve(ObjectId blogId) {
		Assert.notNull(blogId);
		return blogRepo.findOne(blogId);
	}

	@Override
	public void storeBlogTrail(BlogTrail trail) {
		trailRepo.save(trail);
		blogRepo.findOne(trail.getBlogId());
	}

	@Override
	public List<BlogTrail> retrieveTrails(List<ObjectId> trailIds) {
		return null;
	}

}
