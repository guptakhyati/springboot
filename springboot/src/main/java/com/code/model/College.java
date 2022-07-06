package com.code.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
@Entity
@Table
public class College {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	private String collegeName;
	private String collegeCountry;
	private String collegeState;
	private String collegeCity;
	private String collegeImages;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getCollegeCountry() {
		return collegeCountry;
	}
	public void setCollegeCountry(String collegeCountry) {
		this.collegeCountry = collegeCountry;
	}
	public String getCollegeState() {
		return collegeState;
	}
	public void setCollegeState(String collegeState) {
		this.collegeState = collegeState;
	}
	public String getCollegeCity() {
		return collegeCity;
	}
	public void setCollegeCity(String collegeCity) {
		this.collegeCity = collegeCity;
	}
	public String getCollegeImages() {
		return collegeImages;
	}
	public void setCollegeImages(String collegeImages) {
		this.collegeImages = collegeImages;
	}




	
}
