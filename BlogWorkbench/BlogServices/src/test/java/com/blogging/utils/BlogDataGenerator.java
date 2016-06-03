package com.blogging.utils;

import java.util.Date;

import org.bson.types.ObjectId;

import com.blogging.model.Blog;
import com.blogging.model.BlogTrail;

public enum BlogDataGenerator {
	Generator;
	
	public Blog createBlog() {
		Blog blog = new Blog();
		blog.setContent("This is Test Blog content.");
		blog.setDescription("This is Test Blog Description.");
		blog.setSubmittedBy(new ObjectId("507f191e810c19729de860ea"));
		blog.setSubmittedDate(new Date());
		return blog;
	}
	
	public BlogTrail createTrail() {
		BlogTrail trail = new BlogTrail();
		trail.setContent("Test Trail");
		trail.setSubmittedBy(new ObjectId());
		trail.setSubmittedDate(new Date());
		trail.setBlogId(new ObjectId());
		return trail;
	}
}