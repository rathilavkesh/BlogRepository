package com.blogging.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blogging.model.BlogTrail;

public interface BlogTrailRepository extends MongoRepository<BlogTrail, Integer> {

}
