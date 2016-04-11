package com.blogging.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.blogging.model.Role;

public interface RoleRepository extends MongoRepository<Role, ObjectId> {

}
