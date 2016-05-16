package com.blogging.service;

import java.util.List;

import javax.annotation.Resource;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.blogging.model.Blog;
import com.blogging.model.BlogTrail;
import com.blogging.repository.BlogRepository;
import com.blogging.repository.BlogTrailRepository;

@Service
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
		BlogTrail savedTrail = trailRepo.save(trail);
		Blog blog = blogRepo.findOne(trail.getBlogId());
		blog.getBlogTrailIds().add(savedTrail.getBlogTrailId());
		blogRepo.save(blog);
		
	}

	@Override
	public List<BlogTrail> retrieveTrails(List<ObjectId> trailIds) {
		return null;
	}

}
