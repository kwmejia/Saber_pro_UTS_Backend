package com.systemsaberpro.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.systemsaberpro.app.entity.Ratings;

public interface RatingsRepository extends  MongoRepository<Ratings, String>{

	@Query("{'studentId': ?0}")
	Ratings findByStudent (String id);
}
