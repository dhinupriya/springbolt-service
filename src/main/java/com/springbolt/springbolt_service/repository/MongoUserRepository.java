package com.springbolt.springbolt_service.repository;

import com.springbolt.springbolt_service.model.MongoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoUserRepository extends MongoRepository<MongoUser,String> {
}
