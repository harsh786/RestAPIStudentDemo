package com.harsh.student.RestAPIStudentDemo.model.EmployeeTest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity(name="gender_tbl")
public class Gender {
	
	private int id;
	private String name;
	
	@Id
	@Column(name="id",nullable=false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="name",nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
