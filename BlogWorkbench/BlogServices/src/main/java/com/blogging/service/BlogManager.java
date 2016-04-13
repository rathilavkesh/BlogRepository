package com.blogging.service;

import org.bson.types.ObjectId;

import com.blogging.model.Blog;
import com.blogging.model.BlogTrail;

public interface BlogManager {

	void createBlog(Blog blog);

	Blog retrieve(ObjectId objectId);

	void storeBlogTrail(BlogTrail trail);

}
