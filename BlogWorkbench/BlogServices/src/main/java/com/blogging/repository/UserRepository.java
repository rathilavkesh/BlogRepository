package com.blogging.repository;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.blogging.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

}
