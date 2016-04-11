package com.blogging.service;

import javax.annotation.Resource;

import com.blogging.model.Blog;
import com.blogging.repository.BlogRepository;

public class BlogManagerImpl implements BlogManager{
	
	@Resource
	private BlogRepository blogRepo;

	@Override
	public void createBlog(Blog blog) {
		blogRepo.save(blog);
	}

}
