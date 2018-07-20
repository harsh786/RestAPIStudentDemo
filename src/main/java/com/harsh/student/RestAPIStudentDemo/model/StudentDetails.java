package com.harsh.student.RestAPIStudentDemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name="STUDENT_DETAILS")
@Table(name="STUDENT_DETAILS")
public class StudentDetails {

	private long Id;
	private String Name;
	
	private Student ObjStudent;
	
	@Transient
	//@OneToOne(mappedBy="studentdetails")
	public Student getObjStudent() {
		return ObjStudent;
	}
	public void setObjStudent(Student objStudent) {
		ObjStudent = objStudent;
	}
	@javax.persistence.Id
	@GeneratedValue
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	
}
