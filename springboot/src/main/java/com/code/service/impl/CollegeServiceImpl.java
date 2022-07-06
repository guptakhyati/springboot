package com.code.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.ComponentScan;

import com.code.model.College;
import com.code.repository.CollegeRepository;
import com.code.service.CollegeService;


@RefreshScope
@Service
@ComponentScan(basePackages={"com.code.service"})
public class CollegeServiceImpl implements CollegeService {
	
	private static final Logger logger = LoggerFactory.getLogger(CollegeServiceImpl.class);

	@Autowired CollegeRepository collegeRepository;
	@Autowired Tracer tracer;

	@Override
	public College getById(int id) {
		
//		try {
//		Thread.sleep(2000);
//	}catch(InterruptedException e){
//		e.printStackTrace();
//	}
		
		logger.info("logs before custom span");
		Span newSpan = this.tracer.nextSpan().name("custom-log");
		
		try (Tracer.SpanInScope ws = this.tracer.withSpan(newSpan.start())) {
		    // ...
		    // You can tag a span
		    newSpan.tag("custom-tag", "##333##");
		    // ...
		    logger.info("Logs in custom span");
		}
		finally {
		    // Once done remember to end the span. This will allow collecting
		    // the span to send it to a distributed tracing system e.g. Zipkin
		    newSpan.end();
		}
		
		// SELECT * FROM course WHERE id = 1;
		College c= collegeRepository.findById(id).orElse(null);
		
		logger.info("logs after custom span");
		
		return c;
	}
	
 
	@Override
	public College getByName(String collegeName) {
		
		College c= collegeRepository.findBycollegeName(collegeName);
		return c;
	}
	
	@Override
	public List<College> getAll() {
		List<College> courseList=collegeRepository.findAll();
		return courseList;
	}
	
	@Override
	public boolean save(College college) {
		System.out.println("id-"+college.getId()+", collegeName-"+college.getCollegeName()+", collegeCountry-"+college.getCollegeCountry()+", collegeState-"+college.getCollegeState()+", collegeCity-"+college.getCollegeCity()+", collegeImages-"+college.getCollegeImages());
		collegeRepository.save(college);
		return true;
	}
	
	@Override
	public boolean update(College college) {
		collegeRepository.save(college);
		return true;
	}

	@Override
	public boolean delete(int id) {
		collegeRepository.deleteById(id);
		return true;
	}


}
 