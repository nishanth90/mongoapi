package com.security.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.security.model.UserDetail;


@Repository
public interface UserRepository extends MongoRepository<UserDetail, String> {
	
	public UserDetail findByUserName(String name);
	
}