package com.javarock.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javarock.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
