package com.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.code.model.College;

@Repository
public interface CollegeRepository extends JpaRepository<College, Integer>{

	College findBycollegeName(String collegeName);

}
