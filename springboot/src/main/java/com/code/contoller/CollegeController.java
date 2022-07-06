package com.code.contoller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.code.model.College;
import com.code.service.CollegeService;


@RestController
@RequestMapping("/college")
@RefreshScope
public class CollegeController {
	 
	@Autowired CollegeService collegeService;

	@Value("${message:default message}")
	private String message;
	
	@GetMapping("/message")
	public String getMessage() {
		return message;
	}
	
	@GetMapping("/id")
	public College getById(@RequestParam(value="id",defaultValue="1")int id) {
	
		return collegeService.getById(id);
	}
	
	@RequestMapping(value="/collegeName",method=RequestMethod.GET)
	public College getByName(@RequestParam(value="collegeName",defaultValue="ManipalUniversityJaipur")String collegeName) {
		return collegeService.getByName(collegeName);
	}
	
	
	@GetMapping
	public List<College> getAll() {
		return collegeService.getAll();
	}
	
	@PostMapping("/save")
	public boolean saveCollege(@RequestBody(required=true)College college) {
		return collegeService.save(college);
	}
	
	@PutMapping
	public boolean update(@RequestBody College college) {
		return collegeService.update(college);
	}
	
	@DeleteMapping 
	public boolean delete(@RequestParam int id) {
		return collegeService.delete(id);
	}
	
}
