package com.blogging.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.blogging.model.Blog;
import com.blogging.model.BlogTrail;

public interface BlogManager {

	Blog createBlog(Blog blog);

	Blog retrieve(ObjectId objectId);

	void storeBlogTrail(BlogTrail trail);

	List<BlogTrail> retrieveTrails(List<ObjectId> trailIds);

}
