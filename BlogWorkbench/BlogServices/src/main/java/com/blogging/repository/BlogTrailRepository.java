package com.blogging.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.blogging.model.BlogTrail;

public interface BlogTrailRepository extends MongoRepository<BlogTrail, ObjectId> {

	List<BlogTrail> findAllByBlogId(ObjectId blogId, Pageable pageable);

}
