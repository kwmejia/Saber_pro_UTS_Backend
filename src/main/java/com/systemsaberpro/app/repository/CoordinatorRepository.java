package com.systemsaberpro.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.systemsaberpro.app.entity.Coordinator;

public interface CoordinatorRepository  extends MongoRepository<Coordinator, String> {

}
