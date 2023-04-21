package com.systemsaberpro.app.repository;

import com.systemsaberpro.app.entity.Student;

public interface FindByNit {
	Student findByNit(String nit);
}
