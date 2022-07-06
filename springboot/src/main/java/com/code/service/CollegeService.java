package com.code.service;

import java.util.List;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import com.code.model.College;

@RefreshScope
@Service
public interface CollegeService {
	College getById(int id);
	College getByName(String collegeName);
	List<College> getAll();
	boolean save(College college);
	boolean update(College college);
	boolean delete(int id);
	
}
