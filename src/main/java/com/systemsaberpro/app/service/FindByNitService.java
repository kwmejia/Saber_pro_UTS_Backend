package com.systemsaberpro.app.service;

import org.springframework.stereotype.Component;

import com.systemsaberpro.app.entity.Student;
import com.systemsaberpro.app.repository.FindByNit;

@Component
public class FindByNitService implements FindByNit{
	@Override
	public Student findByNit(String nit) {
		final Student student = new Student();
		return student;
	}
}
