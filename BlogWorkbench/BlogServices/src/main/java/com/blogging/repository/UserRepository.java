package com.blogging.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blogging.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
