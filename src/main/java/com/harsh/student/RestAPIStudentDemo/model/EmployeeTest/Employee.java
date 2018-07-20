package com.harsh.student.RestAPIStudentDemo.model.EmployeeTest;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.AccessType;

@Entity(name="employee_tbl")

public class Employee {

	
	private int id;
	/*
	 @NotNull
	@Size(min=3, max=5)
	private String name;
	 @NotNull
	 @Size(min=3, max=8)
	private String rollNo;
	 @NotNull
	private  Gender objGender;
	*/
	 @NotNull
	private Set<Hobbies> objHobbies;
	 
	 @NotNull
	private department objDepartment;
	
   
	private boolean status;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}/*
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="gender_id",nullable=false)
	public Gender getObjGender() {
		return objGender;
	}
	public void setObjGender(Gender objGender) {
		this.objGender = objGender;
	}
	*/
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="employee_hobbies_tbl",joinColumns={@JoinColumn(name="emp_id")},inverseJoinColumns={@JoinColumn(name="hobby_id")})
	public Set<Hobbies> getObjHobbies() {
		return objHobbies;
	}
	public void setObjHobbies(Set<Hobbies> objHobbies) {
		this.objHobbies = objHobbies;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="dept_id",nullable=false)
	public department getObjDepartment() {
		return objDepartment;
	}
	public void setObjDepartment(department objDepartment) {
		this.objDepartment = objDepartment;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	 
}
