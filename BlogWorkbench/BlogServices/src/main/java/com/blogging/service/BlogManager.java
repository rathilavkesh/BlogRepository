package com.blogging.service;

import org.bson.types.ObjectId;

import com.blogging.model.Blog;

public interface BlogManager {

	void createBlog(Blog blog);

	Blog retrieve(ObjectId objectId);

}
