package com.systemsaberpro.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.systemsaberpro.app.entity.Student;

public interface StudentRepository extends MongoRepository<Student, String>{
  
	public Student findByNit(String nit);
}
