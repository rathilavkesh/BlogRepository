package com.blogging.service;

import javax.annotation.Resource;

import org.bson.types.ObjectId;
import org.springframework.util.Assert;

import com.blogging.model.Blog;
import com.blogging.repository.BlogRepository;

public class BlogManagerImpl implements BlogManager{
	
	@Resource
	private BlogRepository blogRepo;

	@Override
	public void createBlog(Blog blog) {
		blogRepo.save(blog);
	}

	@Override
	public Blog retrieve(ObjectId blogId) {
		Assert.notNull(blogId);
		return blogRepo.findOne(blogId);
	}

}
